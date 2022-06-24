package service.impl;

import model.Employee;
import service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employees = new ArrayList<>();
    static {

    }
    @Override
    public void add() {

    }

    @Override
    public void display() {
        if (employees.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào.");
            add();
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
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
