package service.impl;

import common.TypeInformation;
import model.Customer;
import service.CustomerService;
import service.ObjectService;
import util.ReadFurama;
import util.WriteFurama;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService, ObjectService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_CUSTOMER = "furama/src/data/customer.csv";

    @Override
    public void add() {
        System.out.print("Nhập mã khách hàng: ");
        String customerId = scanner.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        LocalDate birthDay;
        while (true) {
            try {
                System.out.print("Nhập ngày tháng năm sinh theo định dạng dd-MM-yyyy: ");
                birthDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
            }
        }
        String sex = TypeInformation.getTypeSex();
        System.out.print("Nhập số CMND: ");
        String identityCardNumber = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String tel = scanner.nextLine();
        System.out.print("Nhập số email: ");
        String email = scanner.nextLine();
        String typeCustomer = TypeInformation.getTypeCustomer();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(customerId, name, birthDay, sex, identityCardNumber, tel, email, typeCustomer, address));
        WriteFurama.writeCustomerToCSV(customers, PATH_FILE_CUSTOMER, true);
        System.out.println("Bạn đã thêm thành công khách hàng: " + name);
    }

    @Override
    public void display() {
        List<Customer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        if (customers.isEmpty()) {
            System.out.println("Chưa có thông tin, mời bạn thêm vào");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public void editById(String id) {
        List<Customer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPersonId().equalsIgnoreCase(id)) {
                System.out.println(customers.get(i));
                System.out.println("Đây là thông tin khách hàng bạn muốn chỉnh sửa.");
                System.out.print("Chỉnh sửa tên khách hàng: ");
                customers.get(i).setName(scanner.nextLine());
                System.out.println("Chỉnh sửa ngày sinh");
                while (true) {
                    try {
                        System.out.print("Nhập ngày tháng năm sinh theo định dạng dd-MM-yyyy: ");
                        customers.get(i).setDateOfBirth(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        break;
                    } catch (DateTimeParseException e) {
                        System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
                    }
                }
                System.out.println("Chỉnh sửa giới tính");
                customers.get(i).setSex(TypeInformation.getTypeSex());
                System.out.print("Chỉnh sửa số CMND: ");
                customers.get(i).setIdentityCardNumber(scanner.nextLine());
                System.out.print("Chỉnh sửa số điện thoại: ");
                customers.get(i).setTel(scanner.nextLine());
                System.out.print("Chỉnh sửa email: ");
                customers.get(i).setEmail(scanner.nextLine());
                System.out.println("Chỉnh sửa loại khách");
                customers.get(i).setTypeCustomer(TypeInformation.getTypeCustomer());
                System.out.print("Chỉnh sửa địa chỉ khách hàng: ");
                customers.get(i).setAddress(scanner.nextLine());
                System.out.println("Thông tin đã được cập nhật");
                System.out.println(customers.get(i));
                WriteFurama.writeCustomerToCSV(customers, PATH_FILE_CUSTOMER, false);
                return;
            }
        }
        System.out.println("Mã khách hàng bạn nhập không tồn tại.");
    }

    @Override
    public Object getObject() {
        List<Customer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        System.out.println("Danh sách khách hàng");
        if(customers.isEmpty()) {
            System.out.println("Chưa có thông tin, mời bạn thêm vào!");
            add();
        }
        for (Customer c : customers) {
            System.out.println("ID: " + c.getPersonId() + "," + "tên KH: " + c.getName() + ", " + " sđt: " + c.getTel() + ", " + "email: " + c.getEmail());
        }
        System.out.print("Chọn mã khách hàng: ");
        String id = scanner.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPersonId().equalsIgnoreCase(id)) {
                return customers.get(i);
            }
        }
        return null;
    }
}
