package util;

import model.Producer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteProducer {
    public static List<Producer> readProducerToCSV(String pathFile) {
        List<Producer> producers = new ArrayList<>();
        BufferedReader bufferedReader = null;
        String line;
        Producer producer;
        String[] array;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                producer = new Producer(Integer.parseInt(array[0]),array[1],array[2]);
                producers.add(producer);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Đường dẫn không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return producers;
    }
    public static void writeProducerToCSV(List<Producer> producers, String pathFile, boolean append) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            for (int i = 0; i < producers.size(); i++) {
                bufferedWriter.write(producers.get(i).getInformationToCSV());
            }
            bufferedWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
