package controller;

import service.CustomerService;
import service.InvoiceService;
import service.impl.CustomerServiceImpl;
import service.impl.InvoiceServiceImpl;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService = new CustomerServiceImpl();
    private static InvoiceService invoiceService = new InvoiceServiceImpl();
    public static void displayMainMenu() {
        System.out.println();
        String choose = "";
        do {
            System.out.println("Chọn chức năng theo số (để tiếp tục)" +
                    "\n 1. Thêm mới khách hàng" +
                    "\n 2. Hiển thị thông tin khách hàng" +
                    "\n 3. Tìm kiếm khách hàng" +
                    "\n 4. Thêm mới hoá đơn" +
                    "\n 5. Chỉnh sửa hoá đơn" +
                    "\n 6. Hiển thị thông tin chi tiết hoá đơn" +
                    "\n 7. Thoát khỏi chương trình");
            System.out.print("Lựa chọn của bạn: ");
            choose = scanner.nextLine();
            System.out.println();
            switch (choose) {
                case "1":
                    customerService.add();
                    break;
                case "2":
                    customerService.display();
                    break;
                case "3":
                    customerService.findCustomerByName();
                    break;
                case "4":
                    invoiceService.add();
                    break;
                case "5":
                    invoiceService.editInvoice();
                    break;
                case "6":
                    invoiceService.display();
                    break;
                case "7":
                    System.out.println("Bạn đã thoát khỏi chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn chưa có! Mời bạn chọn lại");
            }
        } while (!choose.equals("6"));
    }
}
