package service.impl;

import model.Customer;
import service.CustomerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer("KH001", "huy", LocalDate.parse("1999-02-20"), "nam", "123456789", "0935507495", "huynguqa@gmail.com", "Vip", "ĐN"));
        customers.add(new Customer("KH002", "hung", LocalDate.parse("2001-01-11"), "nam", "46512561", "0932890543", "hung@gmail.com", "Vip", "ĐN"));
    }

    @Override
    public void add() {

    }

    @Override
    public void display() {
        if (customers.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào.");
            add();
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
