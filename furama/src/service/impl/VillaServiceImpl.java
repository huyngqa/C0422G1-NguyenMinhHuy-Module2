package service.impl;

import model.Villa;
import service.Service;
import service.VillaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VillaServiceImpl implements VillaService {
    List<Villa> villas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.print("Nhập tên dịch vụ: ");
        String name = scanner.nextLine();
        double usableArea = 0;
        double rentalCosts = 0;
        int maximumNumOfPeople = 0;
        double swimmingPoolArea = 0;
        int numOfFloor = 0;
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
        System.out.print("Kiểu thuê: ");
        String rentalType = scanner.nextLine();
        System.out.print("Tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
        villas.add(new Villa(name, usableArea, rentalCosts, maximumNumOfPeople, rentalType, roomStandard, swimmingPoolArea, numOfFloor));
        System.out.println("Bạn đã thêm mới dịch vụ thành công");
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
}
