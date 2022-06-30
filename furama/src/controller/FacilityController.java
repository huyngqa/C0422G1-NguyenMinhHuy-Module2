package controller;

import service.FacilityService;
import service.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    static FacilityService facilityService = new FacilityServiceImpl();
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
                    System.out.println("DANH SÁCH DỊCH VỤ");
                    facilityService.display();
                    break;
                case "2":
                    System.out.println("Thêm mới dịch vụ");
                    facilityService.add();
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
