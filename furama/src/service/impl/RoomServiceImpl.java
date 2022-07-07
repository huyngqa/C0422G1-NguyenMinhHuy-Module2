package service.impl;

import common.CheckException;
import common.CheckRegex;
import common.TypeInformation;
import common.UserException;
import model.Facility;
import model.Room;
import service.ObjectService;
import util.ReadFurama;
import util.WriteFurama;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RoomServiceImpl implements ObjectService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_FACILITY = "furama/src/data/facility.csv";

    @Override
    public Object addObject() {
        Map<Facility, Integer> facilityMap = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        Set<Facility> set = facilityMap.keySet();
        String name;
        do {
            System.out.print("Nhập tên dịch vụ(Viết hoa chữ cái đầu và không có kí tự đặc biệt): ");
            name = scanner.nextLine();
        } while (!CheckRegex.checkRegexNameService(name));
        for (Facility facility : set) {
            if (facility.getNameService().equalsIgnoreCase(name)) {
                System.out.println("Dịch vụ này đã có!");
                return facility;
            }
        }
        String id;
        do {
            id = "SVRO-";
            System.out.print("Nhập mã dịch vụ (gồm có 4 số): ");
            id += scanner.nextLine();
        } while (!CheckRegex.checkRegexFacilityId(id));
        double usableArea;
        while (true) {
            try {
                System.out.print("Nhập diện tích sử dụng: ");
                usableArea = Double.parseDouble(scanner.nextLine());
                CheckException.checkArea(usableArea);
                break;
            } catch (NumberFormatException | UserException exception) {
                System.err.println(exception.getMessage());
            }
        }
        int rentalCosts;
        while (true) {
            try {
                System.out.print("Nhập chi phí thuê: ");
                rentalCosts = Integer.parseInt(scanner.nextLine());
                CheckException.checkInteger(rentalCosts);
                break;
            } catch (NumberFormatException | UserException exception) {
                System.err.println(exception.getMessage());
            }
        }
        int maximumNumOfPeople;
        while (true) {
            try {
                System.out.print("Số người tối đa: ");
                maximumNumOfPeople = Integer.parseInt(scanner.nextLine());
                CheckException.checkMaxOfPeople(maximumNumOfPeople);
                break;
            } catch (NumberFormatException | UserException exception) {
                System.err.println(exception.getMessage());
            }
        }
        String rentalType = TypeInformation.getRentalType();
        System.out.print("Dịch vụ miễn phí đi kèm: ");
        String freeService = scanner.nextLine();
        Room room = new Room(id, name, usableArea, rentalCosts, maximumNumOfPeople, rentalType, freeService);
        facilityMap.put(room, 0);
        WriteFurama.writeFacilityToCSV(facilityMap, PATH_FILE_FACILITY, false);
        System.out.println("Bạn đã thêm mới dịch vụ thành công");
        return room;
    }
}
