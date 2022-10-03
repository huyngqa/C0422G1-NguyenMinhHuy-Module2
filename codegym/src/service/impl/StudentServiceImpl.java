package service.impl;

import common.CheckRegex;
import model.Person;
import model.Student;
import service.PersonService;
import util.Write;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements PersonService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_PERSON = "codegym/src/data/person.csv";

    @Override
    public void addPerson() {
        System.out.println("Thêm mới học viên");
        String personId = "";
        do {
            System.out.print("Nhập mã định danh(Nhập 3 số): ");
            personId = "HV-" + scanner.nextLine();
        } while (!CheckRegex.checkRegexPersonId(personId));
        System.out.print("Nhập họ và tên học viên: ");
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
        double points = 0;
        while (true) {
            try {
                System.out.print("Nhập điểm: ");
                points = Integer.parseInt(scanner.nextLine());
                if (points < 0 || points > 10) {
                    System.err.println("Điểm phải từ 0 -> 10");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.print("Nhập tên lớp: ");
        String classesName = scanner.nextLine();
        LocalDate dateOfStudy;
        while (true) {
            try {
                System.out.print("Nhập ngày nhập học theo định dạng dd/MM/yyyy: ");
                dateOfStudy = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng năm 'dd/MM/yyyy'!");
            }
        }
        List<Person> people = new ArrayList<>();
        people.add(new Student(personId, personName, birthDay, address, tel, points, classesName, dateOfStudy));
        Write.writePersonToCSV(people, PATH_FILE_PERSON, true);
        System.out.println("Đã thêm thành công học viên: " + personName);
    }
}
