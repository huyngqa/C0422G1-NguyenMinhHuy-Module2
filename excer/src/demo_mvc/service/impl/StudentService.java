package demo_mvc.service.impl;

import demo_mvc.model.Student;
import demo_mvc.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "huy", "co4"));
        students.add(new Student(2, "trung", "co4"));
        students.add(new Student(3, "hung", "co4"));
        students.add(new Student(4, "quynh", "co4"));
    }

    @Override
    public void searchByName(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                System.out.println(students.get(i));
            }
        }
    }

    @Override
    public void display() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void add() {
        System.out.print("Nhập id học viên bạn muốn thêm vào: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên học viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập lớp học viên: ");
        String className = scanner.nextLine();
        students.add(new Student(id, name, className));
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
