package controller;

import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeService employeeService = new EmployeeServiceImpl();

    public static void displayEmployeeMenu() {
        String choose = "";
        do {
            System.out.println("Lựa chọn chức năng " +
                    "\n 1. Hiển thị danh sách nhân viên" +
                    "\n 2. Thêm mới nhân viên" +
                    "\n 3. Chỉnh sửa thông tin nhân viên" +
                    "\n 4. Quay về menu");
            System.out.print("Nhập lựa chọn của bạn: ");
            choose = scanner.nextLine();
            System.out.println();
            switch (choose) {
                case "1":
                    System.out.println("Danh sách nhân viên");
                    employeeService.display();
                    System.out.println();
                    break;
                case "2":
                    System.out.println("Thêm mới nhân viên");
                    employeeService.add();
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Chỉnh sửa thông tin nhân viên");
                    System.out.print("Nhập mã nhân viên bạn muốn chỉnh sửa: ");
                    String id = scanner.nextLine();
                    employeeService.editById(id);
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Trờ về menu chính!");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Vui lòng chọn lại");
            }
        } while (!choose.equals("4"));

    }
}
