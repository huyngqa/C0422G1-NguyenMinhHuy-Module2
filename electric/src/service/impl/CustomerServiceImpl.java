package service.impl;

import common.AutoIncrement;
import common.CheckExist;
import common.CustomerNotFoundException;
import common.TypeInformation;
import model.Customer;
import model.DomesticCustomer;
import model.OverseasCustomers;
import service.CustomerService;
import util.Read;
import util.Write;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private final String PATH_FILE_CUSTOMER = "electric/src/data/customer.csv";
    private final String PATH_FILE_TYPE_CUSTOMER = "electric/src/data/type_customer.csv";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void findCustomerByName() {
        List<Customer> customers = Read.readCustomerToCSV(PATH_FILE_CUSTOMER);
        System.out.print("Nhập tên khách hàmg muốn tìm kiếm: ");
        String name = scanner.nextLine();
        try {
            CheckExist.checkCustomerExist(PATH_FILE_CUSTOMER, name);
            for (Customer customer : customers) {
                if (customer.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(customer);
                }
            }
        } catch (CustomerNotFoundException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("");
    }

    @Override
    public Customer getCustomer() {
        List<Customer> customers = Read.readCustomerToCSV(PATH_FILE_CUSTOMER);
        if(customers.isEmpty()) {
            return null;
        }
        System.out.println("Mời bạn chọn số thứ tự trong danh sách khách hàng!");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". MKH: " + customers.get(i).getCustomerId() +
                    ", Tên: " + customers.get(i).getCustomerName());
        }
        System.out.print("Mời bạn chọn: ");
        int choose;
        while (true) {
            try {
                System.out.print("Mời bạn chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
                if(choose < 1 || choose > customers.size() ) {
                    System.err.println("Vui lòng chọn đúng số thứ tự trong danh sách!!!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!!!");
            }
        }
        Customer customer = customers.get(choose - 1);
        return customer;
    }

    @Override
    public void display() {
        List<Customer> customers = Read.readCustomerToCSV(PATH_FILE_CUSTOMER);
        if (customers.isEmpty()) {
            System.err.println("Chưa có dữ liệu");
            return;
        }
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Override
    public void add() {
        String choose = "";
        do {
            System.out.println("Mời bạn chọn" + "\n" +
                    "1. Thêm mới khách hàng trong nước" + "\n" +
                    "2. Thêm mới khách hàng nước ngoài" + "\n" +
                    "3. Quay lại" + "\n");
            System.out.print("Mời bạn lựa chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    addDomesticCustomer();
                    break;
                case "2":
                    addOverseasCustomer();
                    break;
                case "3":
                    System.out.println("Quay về menu");
                    break;
                default:
                    System.out.println("Bạn chọn không đúng chức năng! Vui lòng chọn lại.");
            }
        } while (!choose.equals("3"));
    }

    private void addDomesticCustomer() {
        System.out.println("Thêm mới khách hàng Việt Nam");
        String idCustomer = "KHVN-" + AutoIncrement.incrementIdCustomer(PATH_FILE_CUSTOMER);
        System.out.print("Nhập tên khách hàng: ");
        String nameCustomer = scanner.nextLine();
        String typeCustomer = TypeInformation.getInformationTypeCustomer(PATH_FILE_TYPE_CUSTOMER);
        double consumption;
        while (true) {
            try {
                System.out.print("Nhập định mức tiêu thụ: ");
                consumption = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        List<Customer> customers = new ArrayList<>();
        customers.add(new DomesticCustomer(idCustomer, nameCustomer, typeCustomer, consumption));
        Write.writeCustomerToCSV(customers, PATH_FILE_CUSTOMER, true);
    }

    private void addOverseasCustomer() {
        System.out.println("Thêm mới khách hàng nước ngoài");
        String idCustomer = "KHNN-" + AutoIncrement.incrementIdCustomer(PATH_FILE_CUSTOMER);
        System.out.print("Nhập tên khách hàng: ");
        String nameCustomer = scanner.nextLine();
        System.out.print("Nhập quốc tịch: ");
        String nation = scanner.nextLine();
        List<Customer> customers = new ArrayList<>();
        customers.add(new OverseasCustomers(idCustomer, nameCustomer, nation));
        Write.writeCustomerToCSV(customers, PATH_FILE_CUSTOMER, true);
    }
}