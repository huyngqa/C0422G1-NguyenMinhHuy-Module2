package service.impl;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import common.CheckException;
import common.Random;
import common.UserException;
import model.Booking;
import model.Contract;
import model.Customer;
import model.Facility;
import service.BookingService;
import service.ContractService;
import service.CustomerService;
import util.ReadFurama;
import util.WriteFurama;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_BOOKING = "furama/src/data/booking.csv";
    private final String PATH_FILE_CUSTOMER = "furama/src/data/customer.csv";
    private final String PATH_FILE_CONTRACT = "furama/src/data/contract.csv";
    private BookingService bookingService = new BookingServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    public void add() {
        Set<Booking> bookings = ReadFurama.readBookingToCSV(PATH_FILE_BOOKING);
        if (bookings.isEmpty()) {
            System.err.println("Chưa có dữ liệu, mời bạn chọn chức năng thêm mới dịch vụ!");
            return;
        }
        List<Contract> contracts = ReadFurama.readContractToCSV(PATH_FILE_CONTRACT);
        String idContract = "HD-" + Random.getRandom();
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getContractId().equals(idContract)) {
                idContract = "HD-" + Random.getRandom();
                i = 0;
            }
        }
        Booking booking = bookingService.getBookingById();
        if (booking == null) {
            System.out.println("Đã xử lí hết booking");
            return;
        }
        int depositAdvance;
        while (true) {
            try {
                System.out.print("Nhập số tiền cọc trước: ");
                depositAdvance = Integer.parseInt(scanner.nextLine());
                CheckException.checkInteger(depositAdvance);
                break;
            } catch (NumberFormatException | UserException exception) {
                System.out.println(exception.getMessage());
            }
        }
        int totalPayment;
        while (true) {
            try {
                System.out.print("Nhập tổng số tiền thanh toán: ");
                totalPayment = Integer.parseInt(scanner.nextLine());
                CheckException.checkInteger(totalPayment);
                break;
            } catch (NumberFormatException | UserException exception) {
                System.out.println(exception.getMessage());
            }
        }
        Contract contract = new Contract(idContract, booking, depositAdvance, totalPayment, booking);
        contracts.add(contract);
        WriteFurama.writeContractToCSV(contracts, PATH_FILE_CONTRACT, false);
        System.out.println("Tạo hợp đồng thành công!!!");
    }

    @Override
    public void display() {
        List<Contract> contracts = ReadFurama.readContractToCSV(PATH_FILE_CONTRACT);
        if(contracts.isEmpty()) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
        System.out.println("Danh sách hợp đồng!");
        for (Contract contract : contracts) {
            System.out.println(contract);
        }
    }

    @Override
    public void editById(String id) {

    }
}
