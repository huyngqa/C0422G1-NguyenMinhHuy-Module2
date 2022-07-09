package util;

import model.Customer;
import model.Invoice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Write {
    public static void writeObjectToCSV(List<String> strings, String pathFile, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String str : strings) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeCustomerToCSV(List<Customer> customers, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        for (Customer customer : customers) {
            strings.add(customer.getCustomerToCSV());
        }
        writeObjectToCSV(strings, pathFile, append);
    }

    public static void writeInvoiceToCSV(List<Invoice> invoices, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        for (Invoice invoice : invoices) {
            strings.add(invoice.getInvoiceToCSV());
        }
        writeObjectToCSV(strings, pathFile, append);
    }
}
