package service.impl;

import common.CheckRegex;
import model.Room;
import service.VillaService;

import java.util.Scanner;

public class RoomServiceImpl implements VillaService {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Object addObject() {
        String id = "SVRO-";
        do {
            System.out.print("Nhập mã dịch vụ (gồm có 4 số): ");
            id += scanner.nextLine();
        } while (!CheckRegex.checkRegexFacilityId(id));
        System.out.print("Nhập tên dịch vụ: ");
        String name = scanner.nextLine();
        double usableArea;
        double rentalCosts;
        int maximumNumOfPeople;
        while (true) {
            try {
                System.out.print("Nhập diện tích sử dụng: ");
                usableArea = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập chi phí thuê: ");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                System.out.print("Số người tối đa: ");
                maximumNumOfPeople = Integer.parseInt(scanner.nextLine());
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
        System.out.print("Dịch vụ miễn phí đi kèm: ");
        String freeService = scanner.nextLine();
        Room room = new Room(id, name, usableArea, rentalCosts, maximumNumOfPeople, rentalType, freeService);
        return room;
    }
}
