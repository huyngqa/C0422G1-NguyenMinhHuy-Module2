package service.impl;

import common.CheckException;
import common.CheckRegex;
import common.TypeInformation;
import common.UserException;
import model.Customer;
import service.CustomerService;
import util.ReadFurama;
import util.WriteFurama;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_CUSTOMER = "furama/src/data/customer.csv";

    @Override
    public void add() {
        System.out.print("Nhập mã khách hàng: ");
        String customerId = scanner.nextLine();
        String name;
        do {
            System.out.print("Nhập tên khách hàng: ");
            name = scanner.nextLine();
            if(!CheckRegex.checkRegexPersonName(name)) {
                System.err.println("Tên phải viết hoa chữ cái đầu, không được có kí tự số và kí tự đặc biệt!");
            }
        }while (!CheckRegex.checkRegexPersonName(name));
        LocalDate birthDay;
        while (true) {
            try {
                System.out.print("Nhập ngày tháng năm sinh theo định dạng dd-MM-yyyy: ");
                birthDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                CheckException.checkDateOfBirth(birthDay);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
            } catch (UserException userException) {
                System.err.println(userException.getMessage());
            }
        }
        String sex = TypeInformation.getTypeSex();
        System.out.print("Nhập số CMND: ");
        String identityCardNumber = scanner.nextLine();
        String tel;
        do {
            System.out.print("Nhập số điện thoại(0XXXXXXXXX): ");
            tel = scanner.nextLine();
        } while (!CheckRegex.checkRegexPhone(tel));
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
                System.out.println("Chỉnh sửa tên");
                String name;
                do {
                    System.out.print("Nhập tên khách hàng: ");
                    name = scanner.nextLine();
                    if(!CheckRegex.checkRegexPersonName(name)) {
                        System.err.println("Tên phải viết hoa chữ cái đầu, không được có kí tự số và kí tự đặc biệt!");
                        continue;
                    }
                    customers.get(i).setName(name);
                }while (!CheckRegex.checkRegexPersonName(name));
                System.out.println("Chỉnh sửa ngày sinh");
                LocalDate dateOfBirth;
                while (true) {
                    try {
                        System.out.print("Nhập ngày tháng năm sinh theo định dạng dd-MM-yyyy: ");
                        dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        CheckException.checkDateOfBirth(dateOfBirth);
                        customers.get(i).setDateOfBirth(dateOfBirth);
                        break;
                    } catch (DateTimeParseException e) {
                        System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
                    } catch (UserException userException) {
                        System.err.println(userException.getMessage());
                    }
                }
                System.out.println("Chỉnh sửa giới tính");
                customers.get(i).setSex(TypeInformation.getTypeSex());
                System.out.print("Chỉnh sửa số CMND: ");
                customers.get(i).setIdentityCardNumber(scanner.nextLine());
                String tel;
                do {
                    System.out.print("Chỉnh sửa số điện thoại(0XXXXXXXXX): ");
                    tel = scanner.nextLine();
                } while (!CheckRegex.checkRegexPhone(tel));
                customers.get(i).setTel(tel);
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
    public Customer getCustomerById() {
        List<Customer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        System.out.println("Danh sách khách hàng");
        for (Customer c : customers) {
            System.out.println("ID: " + c.getPersonId() + "," + "tên KH: " + c.getName() + ", " + "sđt: " + c.getTel() + ", " + "email: " + c.getEmail());
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
