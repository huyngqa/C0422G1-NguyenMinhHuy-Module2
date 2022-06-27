package service.impl;

import model.Car;
import model.Producer;
import service.ICarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
    static List<Car> carList = new ArrayList<>();
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
        System.out.print("Số ghế: ");
        int numOfSeats = Integer.parseInt(scanner.nextLine());
        System.out.print("Loại xe: ");
        String vehicleType = scanner.nextLine();
        carList.add(new Car(seaOfControl, producer, yearOfProduction, owner, numOfSeats, vehicleType));
        System.out.println("Bạn đã thêm thành công");
    }

    @Override
    public void display() {
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    @Override
    public void delete(String seaOfControl) {

    }

    @Override
    public void search(String seaOfControl) {

    }
}
