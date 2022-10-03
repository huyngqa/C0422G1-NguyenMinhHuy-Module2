package service.impl;

import common.CheckRegex;
import model.Employee;
import model.Person;
import service.PersonService;
import util.Write;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements PersonService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_PERSON = "codegym/src/data/person.csv";

    @Override
    public void addPerson() {
        System.out.println("Thêm mới nhân viên");
        String personId = "";
        do {
            System.out.print("Nhập mã định danh(Nhập vào 3 số): ");
            personId = "NV-" + scanner.nextLine();
            break;
        } while (!CheckRegex.checkRegexPersonId(personId));
        System.out.print("Nhập họ và tên nhân viên: ");
        String personName = scanner.nextLine();
        LocalDate birthDay;
        while (true) {
            try {
                System.out.print("Nhập ngày tháng năm sinh theo định dạng dd/MM/yyyy: ");
                birthDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng năm 'dd/MM/yyyy'!");
            }
        }
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String tel = scanner.nextLine();
        int salary;
        while (true) {
            try {
                System.out.print("Nhập lương: ");
                salary = Integer.parseInt(scanner.nextLine());
                if (salary <= 0) {
                    System.err.println("Lương phải lớn hơn 0");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.print("Phòng ban làm việc: ");
        String room = scanner.nextLine();

        System.out.print("Vị trí: ");
        String position = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        people.add(new Employee(personId, personName, birthDay, address, tel, salary, room, position));
        Write.writePersonToCSV(people, PATH_FILE_PERSON, true);
        System.out.println("Đã thêm thành công nhân viên: " + personName);
    }
}
