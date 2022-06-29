package service.impl;

import model.Customer;
import service.CustomerService;
import util.ReadAndWriteFurama;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
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
                System.out.print("Nhập ngày tháng năm sinh theo định dạng YYYY-MM-DD: ");
                birthDay = LocalDate.parse(scanner.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng năm 'YYYY-MM-DD'!");
            }
        }
        String sex = "";
        do {
            System.out.println("Chọn giới tính\n" +
                    "1. Nam\n" +
                    "2. Nữ\n" +
                    "3. LGBTS");
            System.out.print("Mời bạn chọn: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    sex = "nam";
                    break;
                case "2":
                    sex = "nữ";
                    break;
                case "3":
                    sex = "lgbts";
                    break;
                default:
                    System.out.println("Bạn chọn chưa đúng! Vui lòng chọn lại");
            }
        } while (sex.equals(""));
        System.out.print("Nhập số CMND: ");
        String identityCardNumber = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String tel = scanner.nextLine();
        System.out.print("Nhập số email: ");
        String email = scanner.nextLine();
        String typeCustomer = "";
        String choose;
        do {
            System.out.println("Chọn loại khách\n" +
                    "1. Diamond.\n" +
                    "2. Platinum.\n" +
                    "3. Gold.\n" +
                    "4. Silver.\n" +
                    "5. Member.");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    typeCustomer = "Diamond";
                    break;
                case "2":
                    typeCustomer = "Platinum";
                    break;
                case "3":
                    typeCustomer = "Gold";
                    break;
                case "4":
                    typeCustomer = "Silver";
                    break;
                case "5":
                    typeCustomer = "Member";
                    break;
                default:
                    System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (typeCustomer.equals(""));
        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(customerId, name, birthDay, sex, identityCardNumber, tel, email, typeCustomer, address));
        ReadAndWriteFurama.writeCustomerToCSV(customers, PATH_FILE_CUSTOMER, true);
        System.out.println("Bạn đã thêm thành công khách hàng: " + name);
    }

    @Override
    public void display() {
        List<Customer> customers = ReadAndWriteFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
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
        List<Customer> customers = ReadAndWriteFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPersonId().equalsIgnoreCase(id)) {
                System.out.println(customers.get(i));
                System.out.println("Đây là thông tin khách hàng bạn muốn chỉnh sửa.");
                System.out.print("Chỉnh sửa tên khách hàng: ");
                customers.get(i).setName(scanner.nextLine());
                System.out.println("Chỉnh sửa ngày sinh");
                while (true) {
                    try {
                        System.out.print("Nhập ngày tháng năm sinh theo định dạng YYYY-MM-DD: ");
                        customers.get(i).setDateOfBirth(LocalDate.parse(scanner.nextLine()));
                        break;
                    } catch (DateTimeParseException e) {
                        System.err.println("Định dạng ngày tháng năm 'YYYY-MM-DD'!");
                    }
                }
                boolean temp = false;
                do {
                    System.out.println("Chỉnh sửa giới tính!");
                    System.out.println("Chọn giới tính\n" +
                            "1. Nam\n" +
                            "2. Nữ\n" +
                            "3. LGBTS");
                    System.out.print("Mời bạn chọn: ");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            customers.get(i).setSex("nam");
                            break;
                        case "2":
                            customers.get(i).setSex("nữ");
                            break;
                        case "3":
                            customers.get(i).setSex("lgbts");
                            break;
                        default:
                            System.out.println("Bạn chọn chưa đúng! Vui lòng chọn lại");
                            temp = true;
                    }
                } while (temp);
                System.out.print("Chỉnh sửa số CMND: ");
                customers.get(i).setIdentityCardNumber(scanner.nextLine());
                System.out.print("Chỉnh sửa số điện thoại: ");
                customers.get(i).setTel(scanner.nextLine());
                System.out.print("Chỉnh sửa email: ");
                customers.get(i).setEmail(scanner.nextLine());
                System.out.println("Chỉnh sửa loại khách");
                String choose = "";
                temp = false;
                do {
                    System.out.println("Chọn loại khách\n" +
                            "1. Diamond.\n" +
                            "2. Platinum.\n" +
                            "3. Gold.\n" +
                            "4. Silver.\n" +
                            "5. Member.");
                    System.out.print("Mời bạn chọn: ");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            customers.get(i).setTypeCustomer("Diamond");
                            break;
                        case "2":
                            customers.get(i).setTypeCustomer("Platinum");
                            break;
                        case "3":
                            customers.get(i).setTypeCustomer("Gold");
                            break;
                        case "4":
                            customers.get(i).setTypeCustomer("Silver");
                            break;
                        case "5":
                            customers.get(i).setTypeCustomer("Member");
                            break;
                        default:
                            System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
                            temp = true;
                    }
                } while (temp);
                System.out.print("Chỉnh sửa địa chỉ khách hàng: ");
                customers.get(i).setAddress(scanner.nextLine());
                System.out.println("Thông tin đã được cập nhật");
                System.out.println(customers.get(i));
                ReadAndWriteFurama.writeCustomerToCSV(customers, PATH_FILE_CUSTOMER, false);
                return;
            }
        }
        System.out.println("Mã khách hàng bạn nhập không tồn tại.");
    }

    @Override
    public void deleteById(String id) {

    }

}
