package controller;

import java.util.Scanner;

public class BookingController {
    private static Scanner scanner = new Scanner(System.in);

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
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Vui lòng chọn lại");
            }
        } while (!choose.equals("6"));
    }
}
