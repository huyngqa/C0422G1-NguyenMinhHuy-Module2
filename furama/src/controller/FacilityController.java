package controller;

import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayFacilityMenu() {
        String choose = "";
        do {
            System.out.println("Lựa chọn của bạn " +
                    "\n 1. Hiển thị các dịch vụ" +
                    "\n 2. Thêm mới dịch vụ" +
                    "\n 3. Hiển thị danh sách đang bảo trì" +
                    "\n 4. Quay lại menu");
            System.out.print("Nhập lựa chọn của bạn: ");
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
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Vui lòng chọn lại");
            }
        } while (!choose.equals("4"));
    }

}
