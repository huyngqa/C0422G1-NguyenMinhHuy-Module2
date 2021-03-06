package service.impl;

import common.CheckException;
import common.Random;
import common.UserException;
import model.Booking;
import model.Customer;
import model.Facility;
import service.BookingService;
import service.CustomerService;
import service.FacilityService;
import util.ReadFurama;
import util.WriteFurama;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class BookingServiceImpl implements BookingService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_BOOKING = "furama/src/data/booking.csv";
    private final String PATH_FILE_CUSTOMER = "furama/src/data/customer.csv";
    private final String PATH_FILE_FACILITY = "furama/src/data/facility.csv";
    private CustomerService customerService = new CustomerServiceImpl();
    private FacilityService facilityService = new FacilityServiceImpl();

    @Override
    public void add() {
        Map<Customer, Integer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        if (customers.isEmpty()) {
            System.err.println("Chưa có dữ liệu, mời bạn chọn chức năng thêm mới khách hàng!");
            return;
        }
        Map<Facility, Integer> facilityMap = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        if (facilityMap.isEmpty()) {
            System.err.println("Chưa có dữ liệu, mời bạn chọn chức năng thêm mới dịch vụ!");
            return;
        }
        Set<Booking> bookings = ReadFurama.readBookingToCSV(PATH_FILE_BOOKING);
        List<Booking> list = new ArrayList<>();
        list.addAll(bookings);
        String idBooking = "BK-" + Random.getRandom();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBookingId().equals(idBooking)) {
                idBooking = "BK-" + Random.getRandom();
                i = 0;
            }
        }
        LocalDate startDay;
        while (true) {
            try {
                System.out.print("Nhập ngày bắt đầu theo định dạng dd-MM-yyyy: ");
                startDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                CheckException.checkDateStartBooking(startDay);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
            } catch (UserException userException) {
                System.err.println(userException.getMessage());
            }
        }
        LocalDate endDay;
        while (true) {
            try {
                System.out.print("Nhập ngày ngày kết thúc theo định dạng dd-MM-yyyy: ");
                endDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                CheckException.checkDateEndBooking(startDay, endDay);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
            } catch (UserException userException) {
                System.err.println(userException.getMessage());
            }
        }
        Customer customer;
        do {
            customer = customerService.getCustomerById();
            if (customer == null) {
                System.err.println("Vui lòng chọn đúng mã khách hàng trong danh sách");
            }
        } while (customer == null);
        Facility facility;
        do {
            facility = facilityService.getFacilityByName();
        } while (facility == null);
        if (facilityMap.get(facility) == 5) {
            System.out.println("Dịch vụ đang sửa chưa, bạn vui lòng booking lại");
            return;
        }
        for (Booking booking : bookings) {
            if ((DAYS.between(booking.getEndDay(), startDay) < 0 &&
                    DAYS.between(booking.getStartDay(), startDay) >= 0)
                    && booking.getNameService().getNameService().equals(facility.getNameService())) {
                System.out.println("Ngày bạn đặt dịch vụ này đã có người sử dụng, mời bạn tạo lại.");
                return;
            } else if ((DAYS.between(endDay, booking.getStartDay()) < 0 && DAYS.between(startDay, booking.getStartDay()) > 0)
                    && booking.getNameService().getNameService().equals(facility.getNameService())) {
                System.out.println("Ngày kết thúc của bạn đã cấn qua thời gian sử dụng của khách hàng khác. Vui lòng tạo lại!!!");
                return;
            }
        }
        int countUseFacility = facilityMap.get(facility) + 1;
        facilityMap.replace(facility, countUseFacility);
        int status = 0;
        Booking booking = new Booking(idBooking, startDay, endDay, customer, facility, status);
        bookings.add(booking);
        WriteFurama.writeFacilityToCSV(facilityMap, PATH_FILE_FACILITY, false);
        WriteFurama.writeBookingToCSV(bookings, PATH_FILE_BOOKING, false);
        System.out.println("Booking thành công!");
    }

    @Override
    public void display() {
        Set<Booking> bookings = ReadFurama.readBookingToCSV(PATH_FILE_BOOKING);
        if (bookings.isEmpty()) {
            System.out.println("Chưa có dữ liệu!!!");
        } else {
            System.out.println("Danh sách booking");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    @Override
    public void editById(String id) {

    }

    @Override
    public Booking getBookingById() {
        Set<Booking> bookings = ReadFurama.readBookingToCSV(PATH_FILE_BOOKING);
        System.out.println("Tạo hợp đồng cho booking!");
        Booking b = null;
        for (Booking booking : bookings) {
            if (booking.getStatus() == 0) {
                System.out.println("Mã booking: " + booking.getBookingId() + ", mã khách hàng: " + booking.getCustomerId().getPersonId()
                        + ", tên dịch vụ: " + booking.getNameService().getNameService());
                b = booking;
                booking.setStatus(1);
                break;
            }
        }
        WriteFurama.writeBookingToCSV(bookings, PATH_FILE_BOOKING, false);
        return b;
    }
}
