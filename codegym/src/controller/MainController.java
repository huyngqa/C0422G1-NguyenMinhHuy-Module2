package controller;

import service.PersonService;
import service.Service;
import service.impl.EmployeeServiceImpl;
import service.impl.PersonServiceImpl;
import service.impl.StudentServiceImpl;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static Service service = new PersonServiceImpl();
    private static PersonService personService = null;
    public static void displayMainMenu() {
        System.out.println();
        String choose = "";
        do {
            System.out.println("Chọn chức năng theo số (để tiếp tục)" +
                    "\n 1. Thêm mới nhân sự" +
                    "\n 2. Xoá nhân sự" +
                    "\n 3. Xem danh sách nhân sự" +
                    "\n 4. Thoát");
            System.out.print("Chọn chức năng: ");
            choose = scanner.nextLine();
            System.out.println();
            switch (choose) {
                case "1":
                    displayAddPersonMenu();
                    break;
                case "2":
                    service.delete();
                    break;
                case "3":
                    service.display();
                    break;
                case "4":
                    System.out.println("Bạn đã thoát khỏi chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Mời bạn chọn lại");
            }
        } while (!choose.equals("4"));
    }

    private static void displayAddPersonMenu() {
        String choose = "";
        do {
            System.out.println("Chọn loại nhân sự cần thêm" + "\n" +
                    "1. Thêm mới nhân viên" + "\n" +
                    "2. Thêm mới học viên" + "\n" +
                    "3. Quay lại" + "\n");
            System.out.print("Chọn chức năng: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    personService = new EmployeeServiceImpl();
                    personService.addPerson();
                    break;
                case "2":
                    personService = new StudentServiceImpl();
                    personService.addPerson();
                    break;
                case "3":
                    System.out.println("Quay về menu");
                    break;
                default:
                    System.out.println("Bạn chọn không đúng chức năng! Vui lòng chọn lại.");
            }
        } while (!choose.equals("3"));
    }
}
