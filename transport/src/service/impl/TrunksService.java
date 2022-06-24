package service.impl;

import model.Producer;
import model.Trunks;
import service.ITrunksService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrunksService implements ITrunksService {
    static List<Trunks> trunksList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    static {
        trunksList.add(new Trunks("43C-12345", ProducerList.producers.get(3), "2009", "huy", 2));
        trunksList.add(new Trunks("43C-41212", ProducerList.producers.get(3), "2011", "huy", 3));
    }

    @Override
    public void add() {
        System.out.print("Nhập bản kiểm soát: ");
        String seaOfControl = scanner.nextLine();
        System.out.print("Nhập tên nhà sản xuất: ");
        String producerName = scanner.nextLine();
        Producer producer = ProducerList.checkProducer(producerName);
        System.out.print("Nhập năm sản xuất: ");
        String yearOfProduction = scanner.nextLine();
        System.out.print("Nhập tên chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập tải trọng: ");
        int tonnage = Integer.parseInt(scanner.nextLine());
        trunksList.add(new Trunks(seaOfControl, producer, yearOfProduction, owner, tonnage));
        System.out.println("Bạn đã thêm thành công");
    }

    @Override
    public void display() {
        for (Trunks trunks : trunksList) {
            System.out.println(trunks);
        }
    }

    @Override
    public void delete(String seaOfControl) {
    }

    @Override
    public void search(String seaOfControl) {

    }
}
