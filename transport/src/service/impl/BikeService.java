package service.impl;

import model.Bike;
import model.Producer;
import service.IBikeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BikeService implements IBikeService {
    static List<Bike> bikeList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);



    @Override
    public void add() {
        System.out.print("Nhập bản kiểm soát: ");
        String seaOfControl = scanner.nextLine();
        System.out.print("Nhập tên nhà sản xuất: ");
        String producerName = scanner.nextLine();
        Producer producer = ProducerService.checkProducer(producerName);
        System.out.print("Nhập năm sản xuất: ");
        String yearOfProduction = scanner.nextLine();
        System.out.print("Nhập tên chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập công suất: ");
        int wattage = Integer.parseInt(scanner.nextLine());
        bikeList.add(new Bike(seaOfControl, producer, yearOfProduction, owner, wattage));
        System.out.println("Bạn đã thêm thành công");
    }

    @Override
    public void display() {
        for (Bike bike : bikeList) {
            System.out.println(bike);
        }
    }

    @Override
    public void delete(String seaOfControl) {

    }

    @Override
    public void search(String seaOfControl) {

    }
}
