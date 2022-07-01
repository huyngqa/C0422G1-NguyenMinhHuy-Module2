package service.impl;

import common.CheckRegex;
import model.Facility;
import model.Room;
import service.FacilityService;
import util.ReadFurama;
import util.WriteFurama;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RoomServiceImpl implements FacilityService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_FACILITY = "furama/src/data/facility.csv";
    @Override
    public Object addObject() {
        Map<Facility, Integer> facilityMap = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        Set<Facility> set = facilityMap.keySet();
        System.out.print("Nhập tên dịch vụ: ");
        String name = scanner.nextLine();
        for (Facility facility : set) {
            if (facility.getNameService().equalsIgnoreCase(name))
                System.out.println("Dịch vụ này đã có!");
            return facility;
        }
        String id = "SVRO-";
        do {
            System.out.print("Nhập mã dịch vụ (gồm có 4 số): ");
            id += scanner.nextLine();
        } while (!CheckRegex.checkRegexFacilityId(id));
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
        facilityMap.put(room, 0);
        WriteFurama.writeFacilityToCSV(facilityMap, PATH_FILE_FACILITY, false);
        System.out.println("Bạn đã thêm mới dịch vụ thành công");
        return room;
    }

    @Override
    public void display() {

    }
}
