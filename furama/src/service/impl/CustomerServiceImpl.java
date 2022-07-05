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
import java.util.Map;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_CUSTOMER = "furama/src/data/customer.csv";

    @Override
    public void add() {
        Map<Customer, Integer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        boolean temp = true;
        String customerId;
        do  {
            System.out.print("Nhập mã khách hàng: ");
            customerId = scanner.nextLine();
            for (Customer customer : customers.keySet()) {
                temp = false;
                if (customer.getPersonId().equalsIgnoreCase(customerId)) {
                    System.out.println("Mã đã tồn tại, mời bạn nhập lại");
                    temp = true;
                    break;
                }
            }
        }while (temp);
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
        String identityCardNumber;
        do  {
            do {
                System.out.print("Nhập số CMND(gồm 9 chữ số): ");
                identityCardNumber = scanner.nextLine();
            } while (!CheckRegex.checkRegexIdentityCard(identityCardNumber));
            for (Customer customer : customers.keySet()) {
                temp = false;
                if (customer.getIdentityCardNumber().equalsIgnoreCase(identityCardNumber)) {
                    System.out.println("Số CMND đã tồn tại");
                    temp = true;
                    break;
                }
            }
        }while (temp);
        String tel;
        do  {
            do {
                System.out.print("Nhập số điện thoại(0XXXXXXXXX): ");
                tel = scanner.nextLine();
            } while (!CheckRegex.checkRegexPhone(tel));
            for (Customer customer : customers.keySet()) {
                temp = false;
                if (customer.getTel().equalsIgnoreCase(tel)) {
                    System.out.println("Số điện thoại đã có người sử dụng");
                    temp = true;
                    break;
                }
            }
        }while (temp);
        String email;
        do  {
            do {
                System.out.print("Nhập email(abc@abc.xyz): ");
                email = scanner.nextLine();
            } while (!CheckRegex.checkRegexEmail(email));
            for (Customer customer : customers.keySet()) {
                temp = false;
                if (customer.getEmail().equalsIgnoreCase(email)) {
                    System.out.println("Email đã có người sử dụng");
                    temp = true;
                    break;
                }
            }
        }while (temp);
        String typeCustomer = TypeInformation.getTypeCustomer();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        customers.put(new Customer(customerId, name, birthDay, sex, identityCardNumber, tel, email, typeCustomer, address),0);
        WriteFurama.writeCustomerToCSV(customers, PATH_FILE_CUSTOMER, false);
        System.out.println("Bạn đã thêm thành công khách hàng: " + name);
    }

    @Override
    public void display() {
        Map<Customer, Integer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        if (customers.isEmpty()) {
            System.out.println("Chưa có thông tin, mời bạn thêm vào");
        } else {
            for (Customer customer : customers.keySet()) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public void editById(String id) {
        Map<Customer, Integer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        for (Customer customer : customers.keySet()) {
            if (customer.getPersonId().equalsIgnoreCase(id)) {
                System.out.println(customer);
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
                    customer.setName(name);
                }while (!CheckRegex.checkRegexPersonName(name));
                System.out.println("Chỉnh sửa ngày sinh");
                LocalDate dateOfBirth;
                while (true) {
                    try {
                        System.out.print("Nhập ngày tháng năm sinh theo định dạng dd-MM-yyyy: ");
                        dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        CheckException.checkDateOfBirth(dateOfBirth);
                        customer.setDateOfBirth(dateOfBirth);
                        break;
                    } catch (DateTimeParseException e) {
                        System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
                    } catch (UserException userException) {
                        System.err.println(userException.getMessage());
                    }
                }
                System.out.println("Chỉnh sửa giới tính");
                customer.setSex(TypeInformation.getTypeSex());
                System.out.println("Chỉnh sửa số CMND: ");
                boolean temp = true;
                String identityCardNumber;
                do  {
                    do {
                        System.out.print("Nhập số CMND(gồm 9 chữ số): ");
                        identityCardNumber = scanner.nextLine();
                    } while (!CheckRegex.checkRegexIdentityCard(identityCardNumber));
                    for (Customer c : customers.keySet()) {
                        temp = false;
                        if (c.getIdentityCardNumber().equalsIgnoreCase(identityCardNumber)) {
                            System.out.println("Số CMND đã tồn tại");
                            temp = true;
                            break;
                        }
                    }
                }while (temp);
                customer.setIdentityCardNumber(identityCardNumber);
                System.out.println("Chỉnh sửa số điện thoại");
                String tel;
                do  {
                    do {
                        System.out.print("Nhập số điện thoại(0XXXXXXXXX): ");
                        tel = scanner.nextLine();
                    } while (!CheckRegex.checkRegexPhone(tel));
                    for (Customer c : customers.keySet()) {
                        temp = false;
                        if (c.getTel().equalsIgnoreCase(tel)) {
                            System.out.println("Số điện thoại đã có người sử dụng");
                            temp = true;
                            break;
                        }
                    }
                }while (temp);
                customer.setTel(tel);
                System.out.println("Chỉnh sửa email: ");
                String email;
                do  {
                    do {
                        System.out.print("Nhập email(abc@abc.xyz): ");
                        email = scanner.nextLine();
                    } while (!CheckRegex.checkRegexEmail(email));
                    for (Customer c : customers.keySet()) {
                        temp = false;
                        if (c.getEmail().equalsIgnoreCase(email)) {
                            System.out.println("Email đã có người sử dụng");
                            temp = true;
                            break;
                        }
                    }
                }while (temp);
                customer.setEmail(email);
                System.out.println("Chỉnh sửa loại khách");
                customer.setTypeCustomer(TypeInformation.getTypeCustomer());
                System.out.print("Chỉnh sửa địa chỉ khách hàng: ");
                customer.setAddress(scanner.nextLine());
                System.out.println("Thông tin đã được cập nhật");
                System.out.println(customer);
                WriteFurama.writeCustomerToCSV(customers, PATH_FILE_CUSTOMER, false);
                return;
            }
        }
        System.out.println("Mã khách hàng bạn nhập không tồn tại.");
    }

    @Override
    public Customer getCustomerById() {
        Map<Customer, Integer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        System.out.println("Danh sách khách hàng");
        for (Customer c : customers.keySet()) {
            System.out.println("ID: " + c.getPersonId() + "," + "tên KH: " + c.getName() + ", " + "sđt: " + c.getTel() + ", " + "email: " + c.getEmail());
        }
        System.out.print("Chọn mã khách hàng: ");
        String id = scanner.nextLine();
        for (Customer c : customers.keySet()) {
            if (c.getPersonId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }
}
