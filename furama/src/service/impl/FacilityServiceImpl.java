package service.impl;

import model.Facility;
import service.FacilityService;
import service.VillaService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    Map<Facility, Integer> mapFacility = new LinkedHashMap<>();
    Scanner scanner = new Scanner(System.in);
    VillaService villaService = new VillaServiceImpl();
    @Override
    public void add() {
        String facility = selectAddFacility();
        if (facility.equals("villa")) {
//            mapFacility
        }
    }

    @Override
    public void display() {

    }

    @Override
    public void editById(String id) {

    }

    @Override
    public void deleteById(String id) {

    }

    private String selectAddFacility() {

        while (true) {
            System.out.println("Bạn muốn thêm dịch vụ nào" + "\n" +
                    "1. Thêm mới Villa" + "\n" +
                    "2. Thêm mới House" + "\n" +
                    "3. Thêm mới Room" + "\n" +
                    "4. Quay lại" + "\n");
            System.out.print("Mời bạn lựa chọn: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":

                    return "villa";
                case "2":
                    return "house";
                case "3":

                    return "room";
                case "4":
                    System.out.println("Quay về menu");
                    return "";
                default:
                    System.out.println("Bạn chọn không đúng chức năng! Vui lòng chọn lại.");
            }
        }
    }
}
