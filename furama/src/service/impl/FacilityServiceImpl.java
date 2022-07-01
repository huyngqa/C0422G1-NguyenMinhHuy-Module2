package service.impl;

import model.Facility;
import service.FacilityService;
import service.ObjectService;
import util.ReadFurama;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService, ObjectService {
    private Scanner scanner = new Scanner(System.in);
    private FacilityService villaService = new VillaServiceImpl();
    private FacilityService roomService = new RoomServiceImpl();
    private FacilityService houseService = new HouseServiceImpl();
    private final String PATH_FILE_FACILITY = "furama/src/data/facility.csv";

    @Override
    public Object addObject() {
        return null;
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
    public Object getObject() {
        Map<Facility, Integer> mapFacility = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        Set<Facility> set = mapFacility.keySet();
        for (Facility facility : set) {
            System.out.println("Mã dịch vụ: " + facility.getFacilityId() + ", tên dịch vụ: " + facility.getNameService());
        }
        System.out.print("Chọn tên dịch vụ: ");
        String name = scanner.nextLine();
        for (Facility facility : set) {
            if(facility.getNameService().equalsIgnoreCase(name)) {
                return facility;
            }
        }
        return null;
    }
}
