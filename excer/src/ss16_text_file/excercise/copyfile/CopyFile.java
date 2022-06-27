package ss16_text_file.excercise.copyfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        CopyFile copyFile = new CopyFile();
        List<String> list = copyFile.readFile("excer/src/ss16_text_file/excercise/copyfile/str.csv");
        copyFile.writeFile("excer/src/ss16_text_file/excercise/copyfile/kq.csv", list);
    }
    public List<String> readFile(String pathFile) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                 list.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại");
        }
        return list;
    }
    public void writeFile(String pathFile,List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
