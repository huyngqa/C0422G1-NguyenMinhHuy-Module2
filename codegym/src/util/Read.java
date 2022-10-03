package util;

import model.Employee;
import model.Person;
import model.Student;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Read {
    public static List<String> readObjectToCSV(String pathFile) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

    public static List<Person> readPersonToCSV(String pathFile) {
        List<Person> people = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        for (String str : strings) {
            arr = str.split(",");
            if (arr[0].contains("NV")) {
                people.add(new Employee(arr[0], arr[1], LocalDate.parse(arr[2]), arr[3], arr[4], Integer.parseInt(arr[5]), arr[6], arr[7]));
            } else if (arr[0].contains("HV")) {
                people.add(new Student(arr[0], arr[1], LocalDate.parse(arr[2]), arr[3], arr[4], Double.parseDouble(arr[5]), arr[6], LocalDate.parse(arr[7])));
            }
        }
        return people;
    }
}
