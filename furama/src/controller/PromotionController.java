package controller;

import service.PromotionService;
import service.impl.PromotionServiceImpl;

import java.util.Scanner;

public class PromotionController {
    private static Scanner scanner = new Scanner(System.in);
    private static PromotionService promotionService = new PromotionServiceImpl();

    public static void displayPromotionMenu() {
        System.out.println();
        String choose = "";
        do {
            System.out.println("Lựa chọn của bạn " +
                    "\n 1. Hiển thị danh sách khách hàng sử dụng dịch vụ" +
                    "\n 2. Danh sách hiển thị khách hàng nhận được voucher" +
                    "\n 3. Quay về menu");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choose = scanner.nextLine();
            System.out.println();
            switch (choose) {
                case "1":
                    promotionService.displayCustomerUsedFacility();
                    break;
                case "2":
                    promotionService.displayCustomerTakePromotion();
                    break;
                case "3":
                    System.out.println("Quay về menu chính");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Mời bạn chọn lại");
            }
        } while (!choose.equals("3"));

    }
}
