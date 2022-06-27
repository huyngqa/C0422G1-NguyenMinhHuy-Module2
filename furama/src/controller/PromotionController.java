package controller;

import java.util.Scanner;

public class PromotionController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayPromotionMenu() {
        System.out.println();
        String choose = "";
        do {
            System.out.println("Lựa chọn của bạn " +
                    "\n 1. Hiển thị danh sách khách hàng sử dụng dịch vụ\n" +
                    "\n 2. Danh sách hiển thị khách hàng nhận được voucher\n" +
                    "\n 3. Quay về menu");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choose = scanner.nextLine();
            System.out.println();
            switch (choose) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Mời bạn chọn lại");
            }
        } while (!choose.equals("3"));

    }
}
