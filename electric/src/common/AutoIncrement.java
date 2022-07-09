package common;

import model.Customer;
import model.Invoice;
import util.Read;

import java.util.List;

public class AutoIncrement {

    public static  String incrementIdCustomer(String pathFile) {
        List<Customer> customers = Read.readCustomerToCSV(pathFile);
        if(customers.isEmpty()) {
            return  "00001";
        }
        String lastCustomerId = customers.get(customers.size() - 1).getCustomerId();
        String id = "" + (Integer.parseInt(lastCustomerId.substring(5)) + 1);
        StringBuilder result = new StringBuilder();
        while (result.length()+id.length()!=5) {
            result.append("0");
        }
        return result + id;
    }
    public static  String incrementIdInvoice(String pathFile) {
        List<Invoice> invoices = Read.readInvoiceToCSV(pathFile);
        if(invoices.isEmpty()) {
            return  "001";
        }
        String lastCustomerId = invoices.get(invoices.size() - 1).getInvoiceId();
        int id = Integer.parseInt(lastCustomerId.substring(4)) + 1;
        if(id < 10) {
            return "00" + id;
        } else if(id < 100) {
            return "0" + id;
        } else {
            return "" + id;
        }
    }
}
