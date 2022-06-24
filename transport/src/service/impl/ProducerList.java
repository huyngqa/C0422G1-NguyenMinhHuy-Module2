package service.impl;

import model.Producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProducerList {
    public static List<Producer> producers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        producers.add(new Producer(1, "VinFast", "VN"));
        producers.add(new Producer(2, "TOYOTA", "JP"));
        producers.add(new Producer(3, "BWM", "GER"));
        producers.add(new Producer(4, "Hyundai", "CHI"));
        producers.add(new Producer(5, "Honda", "JP"));
    }

    public static Producer checkProducer(String producerName) {
        for (int i = 0; i < producers.size(); i++) {
            if (producers.get(i).getProducerName().equalsIgnoreCase(producerName)) {
                return producers.get(i);
            }
        }
        System.out.println("Tên hãng sản xuất chưa có, mời bạn tạo hãng sản xuất mới");
        System.out.print("Nhập id hãng sản xuất: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Quốc gia sản xuất: ");
        String country = scanner.nextLine();
        Producer producer = new Producer(id, producerName, country);
        producers.add(producer);
        System.out.println("Bạn đã thêm nhà sản xuất thành công!");
        return producer;
    }
}
