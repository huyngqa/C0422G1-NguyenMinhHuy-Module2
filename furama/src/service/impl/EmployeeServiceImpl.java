package service.impl;

import common.CheckException;
import common.CheckRegex;
import common.TypeInformation;
import common.UserException;
import model.Customer;
import model.Employee;
import service.EmployeeService;
import util.ReadFurama;
import util.WriteFurama;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_EMPLOYEE = "furama/src/data/employee.csv";

    @Override
    public void add() {
        List<Employee> employees = ReadFurama.readEmployeeToCSV(PATH_FILE_EMPLOYEE);
        System.out.print("Nhập mã nhân viên: ");
        boolean temp = true;
        String employeeId;
        do  {
            System.out.print("Nhập mã nhân viên: ");
            employeeId = scanner.nextLine();
            for (Employee employee : employees) {
                temp = false;
                if (employee.getPersonId().equalsIgnoreCase(employeeId)) {
                    System.out.println("Mã đã tồn tại, mời bạn nhập lại");
                    temp = true;
                    break;
                }
            }
        }while (temp);
        String name;
        do {
            System.out.print("Nhập tên nhân viên: ");
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
            for (Employee employee : employees) {
                temp = false;
                if (employee.getIdentityCardNumber().equalsIgnoreCase(identityCardNumber)) {
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
            for (Employee employee : employees) {
                temp = false;
                if (employee.getTel().equalsIgnoreCase(tel)) {
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
            for (Employee employee : employees) {
                temp = false;
                if (employee.getEmail().equalsIgnoreCase(email)) {
                    System.out.println("Email đã có người sử dụng");
                    temp = true;
                    break;
                }
            }
        }while (temp);
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
        employees.add(new Employee(employeeId, name, birthDay, sex, identityCardNumber, tel, email, level, position, salary));
        WriteFurama.writeEmployeeToCSV(employees, PATH_FILE_EMPLOYEE, false);
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
                System.out.println("Chỉnh sửa tên");
                String name;
                do {
                    System.out.print("Nhập tên nhân viên: ");
                    name = scanner.nextLine();
                    if(!CheckRegex.checkRegexPersonName(name)) {
                        System.err.println("Tên phải viết hoa chữ cái đầu, không được có kí tự số và kí tự đặc biệt!");
                        continue;
                    }
                    employees.get(i).setName(name);
                }while (!CheckRegex.checkRegexPersonName(name));
                System.out.println("Chỉnh sửa ngày sinh");
                LocalDate dateOfBirth;
                while (true) {
                    try {
                        System.out.print("Nhập ngày tháng năm sinh theo định dạng dd-MM-yyyy: ");
                        dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        CheckException.checkDateOfBirth(dateOfBirth);
                        employees.get(i).setDateOfBirth(dateOfBirth);
                        break;
                    } catch (DateTimeParseException e) {
                        System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
                    } catch (UserException userException) {
                        System.err.println(userException.getMessage());
                    }
                }
                employees.get(i).setSex(TypeInformation.getTypeSex());
                System.out.println("Chỉnh sửa số CMND: ");
                boolean temp = true;
                String identityCardNumber;
                do  {
                    do {
                        System.out.print("Nhập số CMND(gồm 9 chữ số): ");
                        identityCardNumber = scanner.nextLine();
                    } while (!CheckRegex.checkRegexIdentityCard(identityCardNumber));
                    for (Employee employee : employees) {
                        temp = false;
                        if (employee.getIdentityCardNumber().equalsIgnoreCase(identityCardNumber)) {
                            System.out.println("Số CMND đã tồn tại");
                            temp = true;
                            break;
                        }
                    }
                }while (temp);
                employees.get(i).setIdentityCardNumber(identityCardNumber);
                System.out.println("Chỉnh sửa số điện thoại");
                String tel;
                do  {
                    do {
                        System.out.print("Nhập số điện thoại(0XXXXXXXXX): ");
                        tel = scanner.nextLine();
                    } while (!CheckRegex.checkRegexPhone(tel));
                    for (Employee employee : employees) {
                        temp = false;
                        if (employee.getTel().equalsIgnoreCase(tel)) {
                            System.out.println("Số điện thoại đã có người sử dụng");
                            temp = true;
                            break;
                        }
                    }
                }while (temp);
                employees.get(i).setTel(tel);
                System.out.println("Chỉnh sửa email: ");
                String email;
                do  {
                    do {
                        System.out.print("Nhập email(abc@abc.xyz): ");
                        email = scanner.nextLine();
                    } while (!CheckRegex.checkRegexEmail(email));
                    for (Employee employee : employees) {
                        temp = false;
                        if (employee.getEmail().equalsIgnoreCase(email)) {
                            System.out.println("Email đã có người sử dụng");
                            temp = true;
                            break;
                        }
                    }
                }while (temp);
                employees.get(i).setEmail(email);
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
