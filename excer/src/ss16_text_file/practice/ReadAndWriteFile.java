package ss16_text_file.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("example.csv");
        int max = findMax(numbers);
        System.out.println(max);
        readAndWriteFile.writeFile("result.csv", max);

    }
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if(!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        } catch (Exception exception) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return numbers;
    }

    public void writeFile(String pathFile, int max) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("Giá trị lớn nhất: " + max);
            writer.newLine();
            writer.close();
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);

        for (int i = 0; i < numbers.size(); i++) {
            if(max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
}
