package service.impl;

import common.CheckRegex;
import model.Person;
import service.Service;
import util.Read;
import util.Write;

import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements Service {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_PERSON = "codegym/src/data/person.csv";

    @Override
    public void delete() {
        List<Person> people = Read.readPersonToCSV(PATH_FILE_PERSON);
        if (people.isEmpty()) {
            System.out.println("Chưa có dữ liệu!!");
            return;
        }
        String personId;
        do {
            System.out.print("Nhập mã định danh nhân sự cần xoá(Nhập đúng định dạng NV hoặc HV-XXX)): ");
            personId = scanner.nextLine();
        } while (!CheckRegex.checkRegexPersonId(personId));
        for (Person person : people) {
            if (person.getPersonId().equals(personId)) {
                while (true) {
                    System.out.println("Bạn có muốn xoá không \n"
                            + "Yes \n"
                            + "No");
                    System.out.print("Mời bạn nhập: ");
                    String choose = scanner.nextLine();
                    if (choose.equalsIgnoreCase("yes")) {
                        people.remove(person);
                        System.out.println("Danh sách sau khi xoá");
                        display();
                        Write.writePersonToCSV(people, PATH_FILE_PERSON, false);
                        return;
                    } else if (choose.equalsIgnoreCase("no")) {
                        return;
                    } else {
                        System.out.println("Chọn yes hoặc no.");
                        continue;
                    }
                }
            }
            System.err.println("Không tồn tại trong hệ thống");
        }
    }

    @Override
    public void display() {
        List<Person> people = Read.readPersonToCSV(PATH_FILE_PERSON);
        if (people.isEmpty()) {
            System.err.println("Chưa có dữ liệu, mời bạn thêm vào!!!");
            return;
        }
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
