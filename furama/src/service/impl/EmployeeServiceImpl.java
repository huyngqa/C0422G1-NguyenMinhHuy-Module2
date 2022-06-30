package service.impl;

import common.TypeInformation;
import model.Employee;
import service.EmployeeService;
import util.ReadFurama;
import util.WriteFurama;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_EMPLOYEE = "furama/src/data/employee.csv";

    @Override
    public void add() {
        System.out.print("Nhập mã nhân viên: ");
        String employeeId = scanner.nextLine();
        System.out.print("Nhập tên nhân viên: ");
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
        String sex = TypeInformation.getTypeSex();
        System.out.print("Nhập số CMND: ");
        String identityCardNumber = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String tel = scanner.nextLine();
        System.out.print("Nhập số email: ");
        String email = scanner.nextLine();
        String level = TypeInformation.getTypeLevel();
        String position = TypeInformation.getTypePosition();
        int salary;
        while (true) {
            try {
                System.out.print("Nhập lương: ");
                salary = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException exception) {
                System.err.println("Vui lòng nhập số!");
            }
        }
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(employeeId, name, birthDay, sex, identityCardNumber, tel, email, level, position, salary));
        WriteFurama.writeEmployeeToCSV(employees, PATH_FILE_EMPLOYEE, true);
        System.out.println("Bạn đã thêm thành công nhân viên: " + name);
    }

    @Override
    public void display() {
        List<Employee> employees = ReadFurama.readEmployeeToCSV(PATH_FILE_EMPLOYEE);
        if (employees.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Override
    public void editById(String id) {
        List<Employee> employees = ReadFurama.readEmployeeToCSV(PATH_FILE_EMPLOYEE);
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getPersonId().equalsIgnoreCase(id)) {
                System.out.println(employees.get(i));
                System.out.println("Đây là thông tin nhân viên bạn muốn chỉnh sửa.");
                System.out.print("Chỉnh sửa tên nhân viên: ");
                employees.get(i).setName(scanner.nextLine());
                System.out.println("Chỉnh sửa ngày sinh");
                while (true) {
                    try {
                        System.out.print("Nhập ngày tháng năm sinh theo định dạng YYYY-MM-DD: ");
                        employees.get(i).setDateOfBirth(LocalDate.parse(scanner.nextLine()));
                        break;
                    } catch (DateTimeParseException e) {
                        System.err.println("Định dạng ngày tháng năm 'YYYY-MM-DD'!");
                    }
                }
                boolean temp = false;
                employees.get(i).setSex(TypeInformation.getTypeSex());
                System.out.print("Chỉnh sửa số CMND: ");
                employees.get(i).setIdentityCardNumber(scanner.nextLine());
                System.out.print("Chỉnh sửa số điện thoại: ");
                employees.get(i).setTel(scanner.nextLine());
                System.out.print("Chỉnh sửa email: ");
                employees.get(i).setEmail(scanner.nextLine());
                System.out.println("Chỉnh sửa trình độ");
                employees.get(i).setLevel(TypeInformation.getTypeLevel());
                System.out.println("Chỉnh sửa vị trí công việc");
                employees.get(i).setPosition(TypeInformation.getTypePosition());
                while (true) {
                    try {
                        System.out.print("Chỉnh sửa lương: ");
                        employees.get(i).setSalary(Integer.parseInt(scanner.nextLine()));
                        break;
                    } catch (NumberFormatException exception) {
                        System.err.println("Vui lòng nhập số!");
                    }
                }
                System.out.println("Thông tin đã được cập nhật");
                System.out.println(employees.get(i));
                WriteFurama.writeEmployeeToCSV(employees, PATH_FILE_EMPLOYEE, false);
                return;
            }
        }
        System.out.println("Mã nhân viên bạn nhập không tồn tại.");
    }

}
