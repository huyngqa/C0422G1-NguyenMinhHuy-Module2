package service.impl;

import model.Facility;
import model.House;
import model.Room;
import model.Villa;
import service.FacilityService;
import service.VillaService;
import util.ReadFurama;
import util.WriteFurama;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {
    //    Map<Facility, Integer> mapFacility = new LinkedHashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private VillaService villaService = new VillaServiceImpl();
    private VillaService roomService = new RoomServiceImpl();
    private VillaService houseService = new HouseServiceImpl();
    private final String PATH_FILE_FACILITY = "furama/src/data/facility.csv";

    @Override
    public void add() {
        Map<Facility, Integer> mapFacility = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        Facility villa = new Villa();
        Facility house = new House();
        Facility room = new Room();
        Set<Facility> set = mapFacility.keySet();
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
                    villa = (Facility) villaService.addObject();
                    if (checkNameService(villa.getNameService())) {
                        int count = mapFacility.get((Facility) villaService.addObject());
                        mapFacility.put(villa, ++count);
                        WriteFurama.writeFacilityToCSV(mapFacility, PATH_FILE_FACILITY, false);
                    } else {
                        mapFacility.put(villa, 0);
                        WriteFurama.writeFacilityToCSV(mapFacility, PATH_FILE_FACILITY, true);
                    }
                    break;
                case "2":
                    house = (Facility) houseService.addObject();
                    if(checkNameService(house.getNameService())) {
                        int count = mapFacility.get((Facility) houseService.addObject());
                        mapFacility.put(house, ++count);
                        WriteFurama.writeFacilityToCSV(mapFacility, PATH_FILE_FACILITY, false);
                    } else {
                        mapFacility.put(house, 0);
                        WriteFurama.writeFacilityToCSV(mapFacility, PATH_FILE_FACILITY, true);
                    }
                    break;
                case "3":
                    room = (Facility) roomService.addObject();
                    if(checkNameService(room.getNameService())) {
                        int count = mapFacility.get((Facility) roomService.addObject());
                        mapFacility.put(room, ++count);
                        WriteFurama.writeFacilityToCSV(mapFacility, PATH_FILE_FACILITY, false);
                    } else {
                        mapFacility.put(room, 0);
                        WriteFurama.writeFacilityToCSV(mapFacility, PATH_FILE_FACILITY, true);
                    }
                    break;
                case "4":
                    System.out.println("Quay về menu");
                    break;
                default:
                    System.out.println("Bạn chọn không đúng chức năng! Vui lòng chọn lại.");
            }
        } while (!choose.equals("4"));
    }

    @Override
    public void display() {
        Map<Facility, Integer> mapFacility = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        Set<Facility> set = mapFacility.keySet();
        if (mapFacility.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào!");
        } else {
            for (Facility key : set) {
                System.out.println(key);
            }
        }
    }

    @Override
    public void editById(String id) {

    }


    private boolean checkNameService(String nameService) {
        Map<Facility, Integer> mapFacility = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        Set<Facility> set = mapFacility.keySet();
        for (Facility facility : set) {
            if (facility.getNameService().equalsIgnoreCase(nameService)) {
                return true;
            }
        }
        return false;
    }
}
