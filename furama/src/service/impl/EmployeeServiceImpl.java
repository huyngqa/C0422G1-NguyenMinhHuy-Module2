package service.impl;

import model.Employee;
import service.EmployeeService;
import util.ReadAndWriteFurama;

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
        String level = "";
        String choose;
        do {
            System.out.println("Nhập trình độ\n" +
                    "1. Trung cấp.\n" +
                    "2. Cao đẳng.\n" +
                    "3. Đại học.\n" +
                    "4. Sau đại học.");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    level = "Trung cấp";
                    break;
                case "2":
                    level = "Cao đẳng";
                    break;
                case "3":
                    level = "Đại học";
                    break;
                 case "4":
                    level = "Sau đại học";
                    break;
                default:
                    System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (level.equals(""));
        String position = "";
        do {
            System.out.println("Nhập vị trí công việc\n" +
                    "1. Lễ tân.\n" +
                    "2. Phục vụ.\n" +
                    "3. Chuyên viên.\n" +
                    "4. Giám sát.\n" +
                    "5. Quản lý.\n" +
                    "6. Giám đốc.");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    position = "Lễ tân";
                    break;
                case "2":
                    position = "Phục vụ";
                    break;
                case "3":
                    position = "Chuyên viên";
                    break;
                case "4":
                    position = "Giám sát";
                    break;
                case "5":
                    position = "Quản lý";
                    break;
                case "6":
                    position = "Giám đốc";
                    break;
                default:
                    System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (position.equals(""));
        int salary = 0;
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
        ReadAndWriteFurama.writeEmployeeToCSV(employees, PATH_FILE_EMPLOYEE, true);
        System.out.println("Bạn đã thêm thành công nhân viên: " + name);
    }

    @Override
    public void display() {
        List<Employee> employees = ReadAndWriteFurama.readEmployeeToCSV(PATH_FILE_EMPLOYEE);
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
        List<Employee> employees = ReadAndWriteFurama.readEmployeeToCSV(PATH_FILE_EMPLOYEE);
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
                            employees.get(i).setSex("nam");
                            break;
                        case "2":
                            employees.get(i).setSex("nữ");
                            break;
                        case "3":
                            employees.get(i).setSex("lgbts");
                            break;
                        default:
                            System.out.println("Bạn chọn chưa đúng! Vui lòng chọn lại");
                            temp = true;
                    }
                } while (temp);
                System.out.print("Chỉnh sửa số CMND: ");
                employees.get(i).setIdentityCardNumber(scanner.nextLine());
                System.out.print("Chỉnh sửa số điện thoại: ");
                employees.get(i).setTel(scanner.nextLine());
                System.out.print("Chỉnh sửa email: ");
                employees.get(i).setEmail(scanner.nextLine());
                System.out.println("Chỉnh sửa trình độ");
                temp = false;
                do {
                    System.out.println("Chọn trình độ\n" +
                            "1. Trung cấp.\n" +
                            "2. Cao đẳng.\n" +
                            "3. Đại học.\n" +
                            "4. Sau đại học: ");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            employees.get(i).setLevel("Trung cấp");
                            break;
                        case "2":
                            employees.get(i).setLevel("Cao đẳng");
                            break;
                        case "3":
                            employees.get(i).setLevel("Đại học");
                            break;
                        case "4":
                            employees.get(i).setLevel("Sau đại học");
                            break;
                        default:
                            System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
                            temp = true;
                    }
                } while (temp);
                System.out.println("Chỉnh sửa vị trí công việc");
                temp = false;
                do {
                    System.out.println("Chọn vị trí công việc\n" +
                            "1. Lễ tân.\n" +
                            "2. Phục vụ.\n" +
                            "3. Chuyên viên.\n" +
                            "4. Giám sát.\n" +
                            "5. Quản lý.\n" +
                            "6. Giám đốc: ");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            employees.get(i).setPosition("Lễ tân");
                            break;
                        case "2":
                            employees.get(i).setPosition("Phục vụ");
                            break;
                        case "3":
                            employees.get(i).setPosition("Chuyên viên");
                            break;
                        case "4":
                            employees.get(i).setPosition("Giám sát");
                            break;
                        case "5":
                            employees.get(i).setPosition("Quản lí");
                            break;
                        case "6":
                            employees.get(i).setPosition("Giám đốc");
                            break;
                        default:
                            System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
                    }
                } while (temp);
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
                ReadAndWriteFurama.writeEmployeeToCSV(employees, PATH_FILE_EMPLOYEE, false);
                return;
            }
        }
        System.out.println("Mã nhân viên bạn nhập không tồn tại.");
    }

    @Override
    public void deleteById(String id) {

    }
}
