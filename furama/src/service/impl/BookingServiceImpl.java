package service.impl;

import common.Random;
import model.Booking;
import model.Customer;
import model.Facility;
import service.BookingService;
import service.ObjectService;
import util.ReadFurama;
import util.WriteFurama;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BookingServiceImpl implements BookingService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_BOOKING = "furama/src/data/booking.csv";
    private final String PATH_FILE_CUSTOMER = "furama/src/data/customer.csv";
    private final String PATH_FILE_EMPLOYEE = "furama/src/data/employee.csv";
    private ObjectService customerService = new CustomerServiceImpl();
    private ObjectService facilityService = new FacilityServiceImpl();

    @Override
    public void add() {
        Set<Booking> bookings = ReadFurama.readBookingToCSV(PATH_FILE_BOOKING);
        List<Booking> list = null;
        list.addAll(bookings);
        String idBooking = "BK-" + Random.getRandom();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBookingId().equals(idBooking)) {
                idBooking = "BK-" + Random.getRandom();
                i = 0;
            }
        }
        System.out.print("Nhập ngày booking: ");
        LocalDate startDay;
        while (true) {
            try {
                System.out.print("Nhập ngày bắt đầu theo định dạng dd-MM-yyyy: ");
                startDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
            }
        }
        LocalDate endDay;
        while (true) {
            try {
                System.out.print("Nhập ngày ngày kết thúc theo định dạng dd-MM-yyyy: ");
                endDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
            }
        }
        Customer customer;
        System.out.println("Chọn mã khách hàng");
        do {
            customer = (Customer) customerService.getObject();
        } while (customer == null);
        Facility facility;
        System.out.println("Chọn tên dịch vụ");
        do {
            facility = (Facility) facilityService.getObject();
        } while (facility == null);
        bookings.add(new Booking(idBooking, startDay, endDay, customer, facility));
        WriteFurama.writeBookingToCSV(bookings, PATH_FILE_BOOKING, false);
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
}
