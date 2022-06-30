package service.impl;

import common.CheckRegex;
import model.Villa;
import service.VillaService;

import java.util.Scanner;

public class VillaServiceImpl implements VillaService {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Object addObject() {
        String id = "SVVL-";
        do {
            System.out.print("Nhập mã dịch vụ (gồm có 4 số): ");
            id += scanner.nextLine();
        } while (!CheckRegex.checkRegexFacilityId(id));
        System.out.print("Nhập tên dịch vụ: ");
        String name = scanner.nextLine();
        double usableArea;
        double rentalCosts;
        int maximumNumOfPeople;
        double swimmingPoolArea;
        int numOfFloor;
        while (true) {
            try {
                System.out.print("Nhập diện tích sử dụng: ");
                usableArea = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập chi phí thuê: ");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                System.out.print("Số người tối đa: ");
                maximumNumOfPeople = Integer.parseInt(scanner.nextLine());
                System.out.print("Diện tích hồ bơi: ");
                swimmingPoolArea = Double.parseDouble(scanner.nextLine());
                System.out.print("Số tầng: ");
                numOfFloor = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException exception) {
                System.err.println("Vui lòng nhập số!");
            }
        }
        String rentalType = "";
        do {
            System.out.println("Chọn kiểu thuê\n" +
                    "1. Thuê theo năm\n" +
                    "2. Thuê theo tháng\n" +
                    "3. Thuê theo ngày\n" +
                    "4. Thuê theo giờ.");
            System.out.print("Mời bạn chọn: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    rentalType = "Thuê theo năm";
                    break;
                case "2":
                    rentalType = "Thuê theo tháng";
                    break;
                case "3":
                    rentalType = "Thuê theo ngày";
                    break;
                case "4":
                    rentalType = "Thuê theo giờ";
                    break;
                default:
                    System.out.println("Bạn chọn lại kiểu thuê!");
            }
        } while (rentalType.equals(""));
        System.out.print("Tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
        Villa villa = new Villa(id, name, usableArea, rentalCosts, maximumNumOfPeople, rentalType, roomStandard, swimmingPoolArea, numOfFloor);
        System.out.println("Bạn đã thêm mới dịch vụ thành công");
        return villa;
    }
}
