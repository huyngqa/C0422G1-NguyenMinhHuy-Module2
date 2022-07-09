package service.impl;

import common.AutoIncrement;
import model.Customer;
import model.DomesticCustomer;
import model.Invoice;
import service.CustomerService;
import service.InvoiceService;
import util.Read;
import util.Write;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceServiceImpl implements InvoiceService {
    private final String PATH_FILE_INVOICE = "electric/src/data/invoice.csv";
    private CustomerService customerService = new CustomerServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("Thêm mới hoá đơn");
        String id = "MHD-" + AutoIncrement.incrementIdInvoice(PATH_FILE_INVOICE);
        Customer customer = customerService.getCustomer();
        if (customer == null) {
            System.err.println("Chưa có dữ liệu khách hàng. Mời bạn thêm vào!!!");
            return;
        }
        LocalDate date;
        while (true) {
            try {
                System.out.print("Nhập ngày tháng in hoá đơn dd-MM-yyyy: ");
                date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
            }
        }
        double amountOfConsumption;
        while (true) {
            try {
                System.out.println("Nhập số lượng tiêu thụ(kW/h): ");
                amountOfConsumption = Double.parseDouble(scanner.nextLine());
                if (amountOfConsumption < 0) {
                    System.err.println("Phải lớn hơn 0");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!!!");
            }
        }
        double unitPrice;
        while (true) {
            try {
                System.out.println("Nhập đơn giá: ");
                unitPrice = Double.parseDouble(scanner.nextLine());
                if (unitPrice < 0) {
                    System.err.println("Phải lớn hơn 0");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!!!");
            }
        }
        double totalPrice = amountOfConsumption * unitPrice;
        if (customer.getCustomerId().contains("VN")) {
            if (((DomesticCustomer) customer).getConsumption() < amountOfConsumption) {
                totalPrice *= (amountOfConsumption - ((DomesticCustomer) customer).getConsumption()) * unitPrice * 2.5;
            }
        }
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(id, customer, date, amountOfConsumption, unitPrice, totalPrice));
        Write.writeInvoiceToCSV(invoices, PATH_FILE_INVOICE, true);
        System.out.println("Đã tạo mới hoá đơn!!!");
    }

    @Override
    public void display() {
        List<Invoice> invoices = Read.readInvoiceToCSV(PATH_FILE_INVOICE);
        if (invoices.isEmpty()) {
            System.err.println("Chưa có dự liệu!!!");
            return;
        }
        System.out.println("DANH SÁCH HOÁ ĐƠN");
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }

    @Override
    public void editInvoice() {
        List<Invoice> invoices = Read.readInvoiceToCSV(PATH_FILE_INVOICE);
        String id = getInvoice();
        if(id == null) {
            System.err.println("Chưa có dữ liệu");
            return;
        }
        for (int i = 0; i < invoices.size(); i++) {
            if(invoices.get(i).getInvoiceId().equals(id)) {
                Customer customer = customerService.getCustomer();
                invoices.get(i).setCustomerId(customer);
                LocalDate date;
                while (true) {
                    try {
                        System.out.print("Nhập ngày tháng in hoá đơn dd-MM-yyyy: ");
                        date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        break;
                    } catch (DateTimeParseException e) {
                        System.err.println("Định dạng ngày tháng năm 'dd-MM-yyyy'!");
                    }
                }
                invoices.get(i).setInvoicePrintDate(date);
                double amountOfConsumption;
                while (true) {
                    try {
                        System.out.println("Nhập số lượng tiêu thụ(kW/h): ");
                        amountOfConsumption = Double.parseDouble(scanner.nextLine());
                        if (amountOfConsumption < 0) {
                            System.err.println("Phải lớn hơn 0");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Vui lòng nhập số!!!");
                    }
                }
                invoices.get(i).setAmountOfConsumption(amountOfConsumption);
                double unitPrice;
                while (true) {
                    try {
                        System.out.println("Nhập đơn giá: ");
                        unitPrice = Double.parseDouble(scanner.nextLine());
                        if (unitPrice < 0) {
                            System.err.println("Phải lớn hơn 0");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Vui lòng nhập số!!!");
                    }
                }
                invoices.get(i).setUnitPrice(unitPrice);
                double totalPrice = amountOfConsumption * unitPrice;
                if (customer.getCustomerId().contains("VN")) {
                    if (((DomesticCustomer) customer).getConsumption() < amountOfConsumption) {
                        totalPrice *= (amountOfConsumption - ((DomesticCustomer) customer).getConsumption()) * unitPrice * 2.5;
                    }
                }
                invoices.get(i).setTotalPrice(totalPrice);
            }
        }
        Write.writeInvoiceToCSV(invoices, PATH_FILE_INVOICE, false);
        System.out.println("Chỉnh sửa thành công");
    }

    private String getInvoice() {
        List<Invoice> invoices = Read.readInvoiceToCSV(PATH_FILE_INVOICE);
        if (invoices.isEmpty()) {
            return null;
        }
        System.out.println("Mời bạn chọn số thứ tự trong danh sách hoá đơn!");
        for (int i = 0; i < invoices.size(); i++) {
            System.out.println((i + 1) + ". Mã hoá đơn: " + invoices.get(i).getInvoiceId() +
                    ", Tên khách hàng: " + invoices.get(i).getCustomerId().getCustomerName()
                    + "(" + invoices.get(i).getCustomerId().getCustomerId() + ")");
        }
        System.out.print("Mời bạn chọn: ");
        int choose;
        while (true) {
            try {
                System.out.print("Mời bạn chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
                if (choose < 1 || choose > invoices.size()) {
                    System.err.println("Vui lòng chọn đúng số thứ tự trong danh sách!!!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!!!");
            }
        }
        String invoiceId = invoices.get(choose - 1).getInvoiceId();
        return invoiceId;
    }
}
