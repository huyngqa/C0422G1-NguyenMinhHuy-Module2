package controller;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println();
        String choose = "";
        do {
            System.out.println("Chọn chức năng " +
                    "\n 1. Quản lý nhân viên" +
                    "\n 2. Quản lý khách hàng" +
                    "\n 3. Quản lý dịch vụ" +
                    "\n 4. Quản lý booking" +
                    "\n 5. Quản lý khuyến mãi" +
                    "\n 6. Thoát khỏi chương trình");
            System.out.print("Lựa chọn của bạn: ");
            choose = scanner.nextLine();
            System.out.println();
            switch (choose) {
                case "1":
                    EmployeeController.displayEmployeeMenu();
                    break;
                case "2":
                    CustomerController.displayCustomerMenu();
                    break;
                case "3":
                    FacilityController.displayFacilityMenu();
                    break;
                case "4":
                    BookingController.displayBookingMenu();
                    break;
                case "5":
                    PromotionController.displayPromotionMenu();
                    break;
                case "6":
                    System.out.println("Bạn đã thoát khỏi chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Mời bạn chọn lại");
            }
        } while (!choose.equals("6"));
    }
}
