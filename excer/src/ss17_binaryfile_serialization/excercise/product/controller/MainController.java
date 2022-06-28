package ss17_binaryfile_serialization.excercise.product.controller;

import ss17_binaryfile_serialization.excercise.product.service.IService;
import ss17_binaryfile_serialization.excercise.product.service.impl.ProductServiceImpl;

import java.util.Scanner;

public class MainController {
    static IService service = new ProductServiceImpl();
    public static void displayMenu() {
        System.out.println("QUẢN LÝ SẢN PHẨM");
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        do {
            System.out.println("Chọn chức năng");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Thoát khỏi chương trình");
            System.out.print("Mời bạn chọn chức năng: ");
            choice = scanner.nextLine();
            System.out.println();
            switch (choice) {
                case "1":
                    System.out.println("Thêm mới sản phẩm");
                    service.add();
                    break;
                case "2":
                    System.out.println("Danh sách sản phẩm");
                    service.display();
                    break;
                case "3":
                    System.out.println("Tìm kiếm thông tin sản phẩm");
                    System.out.print("Nhập mã sản phẩm bạn muốn tìm: ");
                    String id = scanner.nextLine();
                    service.findProductById(id);
                    break;
                case "4":
                    System.out.println("Bạn đã thoát khỏi chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không đúng");
            }
        } while (!choice.equals("4"));
    }
}
