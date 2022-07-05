package service.impl;

import common.CheckException;
import common.Random;
import common.UserException;
import model.Booking;
import model.Contract;
import model.Customer;
import service.BookingService;
import service.ContractService;
import service.CustomerService;
import util.ReadFurama;
import util.WriteFurama;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
        Map<Customer, Integer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        String choice;
        for (Customer customer : customers.keySet()) {
            if (booking.getCustomerId().getPersonId().equals(customer.getPersonId())
                    && customers.get(customer) != 0) {
                System.out.println("Bạn có mã giảm giá, bạn có muôn sử dụng không?");
                while (true) {
                    System.out.println("YES/NO?");
                    System.out.print("Mời bạn chọn: ");
                    choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("yes")) {
                        totalPayment -= totalPayment * customers.get(customer) / 100;
                        customers.replace(customer,0);
                        break;
                    } else if(!choice.equalsIgnoreCase("no")) {
                        System.out.print("Vui lòng chọn: ");
                        System.err.println("YES/NO!!!");
                        continue;
                    }
                    break;
                }
            }
        }
        Contract contract = new Contract(idContract, booking, depositAdvance, totalPayment, booking);
        contracts.add(contract);
        WriteFurama.writeContractToCSV(contracts, PATH_FILE_CONTRACT, false);
        WriteFurama.writeCustomerToCSV(customers, PATH_FILE_CUSTOMER, false);
        System.out.println("Tạo hợp đồng thành công!!!");
    }

    @Override
    public void display() {
        List<Contract> contracts = ReadFurama.readContractToCSV(PATH_FILE_CONTRACT);
        if (contracts.isEmpty()) {
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
