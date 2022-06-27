package util;

import model.Customer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCustomer {
    public static List<Customer> readCustomerToCSV(String pathFile) {
        List<Customer> customers = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                customers.add(new Customer(array[0], array[1], LocalDate.parse(array[2]), array[3], array[4], array[5], array[6], array[7], array[8]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
