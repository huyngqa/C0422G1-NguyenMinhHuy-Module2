package demo_mvc.controller;

import demo_mvc.service.IStudentService;
import demo_mvc.service.impl.StudentService;

import java.util.Scanner;

public class MainController {
    private static IStudentService studentService = new StudentService();
    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        final int DISPLAY = 1;
        final int ADD = 2;
        final int DELETE = 3;
        final int EDIT = 4;
        final int SEARCH = 5;
        final int EXIT = 6;

        boolean temp = true;
        do {
            System.out.println("Chọn chức năng của hệ thống" +
                    "\n 1. Display" +
                    "\n 2. Add" +
                    "\n 3. Delete" +
                    "\n 4. Edit" +
                    "\n 5. Search" +
                    "\n 6. Exit");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            System.out.println();
            switch (choice) {
                case DISPLAY:
                    System.out.println("Chức năng hiển thị");
                    studentService.display();
                    break;
                case ADD:
                    System.out.println("Chức năng thêm mới");
                    studentService.add();
                    break;
                case DELETE:
                    System.out.println("Chức năng xoá");
                case EDIT:
                    System.out.println("Chức năng chỉnh sửa");
                case SEARCH:
                    System.out.println("Chức năng tìm kiếm");
                    System.out.print("Nhập tên bạn muốn tìm: ");
                    String name = scanner.nextLine();
                    studentService.searchByName(name);
                    break;
                case EXIT:
                    temp = false;
                    break;
                default:
                    System.out.println("Bạn chọn chức năng chưa đúng");
            }
        } while (temp);
    }
}
