package ss16_text_file.excercise.country;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestCountry {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader("countries.csv"));
            while ((line = bufferedReader.readLine()) != null) {
                printCountry(parseCsvLine(line));
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader!=null) {
                    bufferedReader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
    public static List<String> parseCsvLine(String csvLine) {
        List<String> list = new ArrayList<>();
        if(csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                list.add(splitData[i]);
            }
        }
        return list;
    }
    private static void printCountry(List<String> country) {
        System.out.println("Country [id= "
                + country.get(0)
                + ", code= " + country.get(1)
                + " , name=" + country.get(2)
                + "]");
    }
}
