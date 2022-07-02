package service.impl;

import model.Facility;
import service.FacilityService;
import util.ReadFurama;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {
    private Scanner scanner = new Scanner(System.in);
    private final String PATH_FILE_FACILITY = "furama/src/data/facility.csv";

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
    public Facility getFacilityByName() {
        Map<Facility, Integer> mapFacility = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        Set<Facility> set = mapFacility.keySet();
        for (Facility facility : set) {
            System.out.println("Mã dịch vụ: " + facility.getFacilityId() + ", tên dịch vụ: " + facility.getNameService());
        }
        System.out.print("Chọn tên dịch vụ: ");
        String name = scanner.nextLine();
        for (Facility facility : set) {
            if (facility.getNameService().equalsIgnoreCase(name) && mapFacility.get(facility) < 5) {
                return facility;
            } else if(facility.getNameService().equalsIgnoreCase(name) && mapFacility.get(facility) == 5) {
                System.err.println("Dịch vụ này đang sửa chữa");
                return null;
            }
        }
        System.err.println("Vui lòng chọn đúng tên trong danh sách");
        return null;
    }

    @Override
    public void displayFacilityMaintenance() {
        Map<Facility, Integer> mapFacility = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        Set<Facility> set = mapFacility.keySet();
        for (Facility facility : set) {
            if (mapFacility.get(facility) == 5) {
                System.out.println(facility);
            }
        }
    }
}
