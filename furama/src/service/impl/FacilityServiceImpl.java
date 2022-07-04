package service.impl;

import model.Facility;
import service.FacilityService;
import util.ReadFurama;
import util.WriteFurama;

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
        for (Facility facility : mapFacility.keySet()) {
            System.out.println("Mã dịch vụ: " + facility.getFacilityId() + ", tên dịch vụ: " + facility.getNameService());
        }
        System.out.print("Chọn tên dịch vụ: ");
        String name = scanner.nextLine();
        for (Facility facility : mapFacility.keySet()) {
            if (facility.getNameService().equalsIgnoreCase(name) && mapFacility.get(facility) < 5) {
                return facility;
            }
        }
        System.err.println("Vui lòng chọn đúng tên trong danh sách");
        return null;
    }

    @Override
    public void displayFacilityMaintenance() {
        Map<Facility, Integer> mapFacility = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        for (Facility facility : mapFacility.keySet()) {
            if (mapFacility.get(facility) == 5) {
                System.out.println(facility);
            }
        }
    }

    @Override
    public void repairFacility() {
        Map<Facility, Integer> mapFacility = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        for (Facility facility : mapFacility.keySet()) {
            if (mapFacility.get(facility) == 5) {
                System.out.println("Mã dịch vụ: " + facility.getFacilityId() + ", tên dịch vụ: "
                        + facility.getNameService() + ", số lần sử dụng: " + mapFacility.get(facility));
            }
        }
        System.out.print("Chọn tên dịch vụ bạn muốn sửa chữa: ");
        String name = scanner.nextLine();
        for (Facility facility : mapFacility.keySet()) {
            if (facility.getNameService().equalsIgnoreCase(name) && mapFacility.get(facility) == 5) {
                mapFacility.replace(facility,0);
                WriteFurama.writeFacilityToCSV(mapFacility,PATH_FILE_FACILITY,false);
                System.out.println("Đã chỉnh sửa xong " + facility.getNameService());
                return;
            } else if(facility.getNameService().equalsIgnoreCase(name) && mapFacility.get(facility) != 5) {
                System.out.println(facility.getNameService() + " chưa cần phải sửa chữa");
                return;
            }
        }
        System.out.println("Tên dịch vụ không tồn tại");
    }

    @Override
    public void repairAllFacility() {
        Map<Facility, Integer> mapFacility = ReadFurama.readFacilityToCSV(PATH_FILE_FACILITY);
        for (Facility facility : mapFacility.keySet()) {
            mapFacility.replace(facility,0);
        }
        WriteFurama.writeFacilityToCSV(mapFacility,PATH_FILE_FACILITY,false);
        System.out.println("Đã bảo dưỡng tất cả các dịch vụ!");
    }
}
