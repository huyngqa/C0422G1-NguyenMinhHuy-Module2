package controller;

import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService = new CustomerServiceImpl();
    public static void displayCustomerMenu() {
        String choose = "";
        do {
            System.out.println("Lựa chọn chức năng " +
                    "\n 1. Hiển thị danh sách khách hàng" +
                    "\n 2. Thêm mới khách hàng" +
                    "\n 3. Chỉnh sửa khách hàng" +
                    "\n 4. Quay về menu");
            System.out.print("Nhập lựa chọn của bạn: ");
            choose = scanner.nextLine();
            System.out.println();
            switch (choose) {
                case "1":
                    System.out.println("Danh sách khách hàng");
                    customerService.display();
                    System.out.println();
                    break;
                case "2":
                    System.out.println("Thêm mới khách hàng");
                    customerService.add();
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Chỉnh sửa thông tin khách hàng");
                    System.out.print("Nhập mã khách hàng bạn muốn tìm kiếm: ");
                    String id = scanner.nextLine();
                    customerService.editById(id);
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Trở về menu chính");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Vui lòng nhập lại");
            }
        } while (!choose.equals("4"));

    }
}
