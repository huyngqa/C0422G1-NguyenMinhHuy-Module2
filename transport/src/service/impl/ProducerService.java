package service.impl;

import model.Producer;
import service.IService;
import util.ReadAndWriteProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProducerService {
    private static Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE_PRODUCER = "transport/src/data/producer.csv";

    public static Producer checkProducer(String producerName) {
        List<Producer> producers = ReadAndWriteProducer.readProducerToCSV(PATH_FILE_PRODUCER);
        for (int i = 0; i < producers.size(); i++) {
            if (producers.get(i).getProducerName().equalsIgnoreCase(producerName)) {
                return producers.get(i);
            }
        }
        return add(producerName);
    }

    public static Producer add(String name) {
        int id;
        while (true) {
            try {
                System.out.print("Nhập mã hãng sản xuất: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!");
            }
        }
        System.out.print("Nhập nơi sản xuất: ");
        String country = scanner.nextLine();
        List<Producer> producers = new ArrayList<>();
        Producer producer = new Producer(id, name, country);
        producers.add(producer);
        ReadAndWriteProducer.writeProducerToCSV(producers, PATH_FILE_PRODUCER, true);
        return producer;
    }

}
