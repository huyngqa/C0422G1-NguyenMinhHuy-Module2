package util;

import model.Customer;
import model.DomesticCustomer;
import model.Invoice;
import model.OverseasCustomers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Read {
    private static final String PATH_FILE_CUSTOMER = "electric/src/data/customer.csv";
    public static List<String> readObjectToCSV(String pathFile) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException exception) {
            System.err.println(exception.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return strings;
    }

    public static List<Customer> readCustomerToCSV(String pathFile) {
        List<Customer> customers = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        for (String str : strings) {
            arr = str.split(",");
            if (arr[0].contains("VN")) {
                customers.add(new DomesticCustomer(arr[0], arr[1], arr[2], Double.parseDouble(arr[3])));
            } else if (arr[0].contains("NN")) {
                customers.add(new OverseasCustomers(arr[0], arr[1], arr[2]));
            }
        }
        return customers;
    }

    public static List<Invoice> readInvoiceToCSV(String pathFile) {
        List<Invoice> invoices = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        List<Customer> customers = readCustomerToCSV(PATH_FILE_CUSTOMER);
        String[] arr;
        Customer customer = null;
        for (String str : strings) {
            arr = str.split(",");
            for (Customer c : customers) {
                if(arr[1].equals(c.getCustomerId())) {
                    customer = c;
                    break;
                }
            }
            invoices.add(new Invoice(arr[0],customer, LocalDate.parse(arr[2]),Double.parseDouble(arr[3]),
                    Double.parseDouble(arr[4]),Double.parseDouble(arr[5])));
        }
        return invoices;
    }
}
