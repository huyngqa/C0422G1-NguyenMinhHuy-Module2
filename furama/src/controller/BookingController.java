package controller;

import service.BookingService;
import service.ContractService;
import service.impl.BookingServiceImpl;
import service.impl.ContractServiceImpl;

import java.util.Scanner;

public class BookingController {
    private static Scanner scanner = new Scanner(System.in);
    private static BookingService bookingService = new BookingServiceImpl();
    private static ContractService contractService = new ContractServiceImpl();
    public static void displayBookingMenu() {
        String choose = "";
        do {
            System.out.println("Lựa chọn chức năng " +
                    "\n 1. Hiển thị danh sách booking" +
                    "\n 2. Thêm mới booking" +
                    "\n 3. Tạo hợp đồng mới" +
                    "\n 4. Hiển thị danh sách hợp đồng" +
                    "\n 5. Chỉnh sửa hợp đồng" +
                    "\n 6. Quay về menu chính");
            System.out.print("Nhập  vào lựa chọn của bạn: ");
            choose = scanner.nextLine();
            System.out.println();
            switch (choose) {
                case "1":
                    bookingService.display();
                    break;
                case "2":
                    System.out.println("Tạo mới booking!");
                    bookingService.add();
                    break;
                case "3":
                    contractService.add();
                    break;
                case "4":
                    contractService.display();
                    break;
                case "5":
                    contractService.editById("");
                    break;
                case "6":
                    System.out.println("Quay về menu");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Vui lòng chọn lại");
            }
        } while (!choose.equals("6"));
    }
}
