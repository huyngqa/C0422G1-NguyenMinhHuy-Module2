package common;

import model.Customer;
import model.Invoice;
import util.Read;

import java.util.List;

public class CheckExist {
    public static void checkCustomerExist(String pathFile, String name) throws CustomerNotFoundException {
        List<Customer> customers = Read.readCustomerToCSV(pathFile);
        for (Customer customer : customers) {
            if (customer.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                return;
        }
        throw new CustomerNotFoundException("Tên khách hàng không tồn tại");
    }
}
