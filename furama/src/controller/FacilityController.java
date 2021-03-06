package controller;

import service.FacilityService;
import service.ObjectService;
import service.impl.FacilityServiceImpl;
import service.impl.HouseServiceImpl;
import service.impl.RoomServiceImpl;
import service.impl.VillaServiceImpl;

import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    private static FacilityService facilityService = new FacilityServiceImpl();
    private static ObjectService facility;

    public static void displayFacilityMenu() {
        String choose = "";
        do {
            System.out.println("Lựa chọn của bạn " +
                    "\n 1. Hiển thị các dịch vụ" +
                    "\n 2. Thêm mới dịch vụ" +
                    "\n 3. Hiển thị danh sách đang bảo trì" +
                    "\n 4. Bảo trì dịch vụ" +
                    "\n 5. Bảo trì tất cả dịch vụ" +
                    "\n 6. Quay lại menu");
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
                    displayMenuAddFacility();
                    break;
                case "3":
                    System.out.println("DANH SÁCH DỊCH VỤ ĐANG BẢO TRÌ");
                    facilityService.displayFacilityMaintenance();
                    break;
                case "4":
                    System.out.println("Bảo trì dịch vụ theo tên");
                    facilityService.repairFacility();
                    break;
                case "5":
                    System.out.println("Bảo trì tất cả dịch vụ");
                    facilityService.repairAllFacility();
                    break;
                case "6":
                    System.out.println("");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Vui lòng chọn lại");
            }
        } while (!choose.equals("6"));
    }

    private static void displayMenuAddFacility() {
        String choose = "";
        do {
            System.out.println("Bạn muốn thêm dịch vụ nào" + "\n" +
                    "1. Thêm mới Villa" + "\n" +
                    "2. Thêm mới House" + "\n" +
                    "3. Thêm mới Room" + "\n" +
                    "4. Quay lại" + "\n");
            System.out.print("Mời bạn lựa chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    facility = new VillaServiceImpl();
                    facility.addObject();
                    break;
                case "2":
                    facility = new HouseServiceImpl();
                    facility.addObject();
                    break;
                case "3":
                    facility = new RoomServiceImpl();
                    facility.addObject();
                    break;
                case "4":
                    System.out.println("Quay về menu");
                    break;
                default:
                    System.out.println("Bạn chọn không đúng chức năng! Vui lòng chọn lại.");
            }
        } while (!choose.equals("4"));
    }

}
