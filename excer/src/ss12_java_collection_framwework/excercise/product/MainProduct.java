package ss12_java_collection_framwework.excercise.product;

import java.util.List;
import java.util.Scanner;

public class MainProduct {
    public static void main(String[] args) {
        displayMain();
    }
    public static void displayMain() {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        boolean temp = true;
        do {
            System.out.println("Chọn chức năng của hệ thống" +
                    "\n 1. Display" +
                    "\n 2. Add" +
                    "\n 3. Delete" +
                    "\n 4. Edit" +
                    "\n 5. Search" +
                    "\n 6. Sort" +
                    "\n 7. Exit");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            System.out.println();
            switch (choice) {
                case 1:
                    System.out.println("Chức năng hiển thị");
                    productManager.displayProduct();
                    break;
                case 2:
                    System.out.println("Chức năng thêm mới");
                    productManager.addProduct();
                    break;
                case 3:
                    System.out.println("Chức năng xoá");
                    System.out.print("Nhập mã sản phẩm bạn muốn xoá: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    productManager.deleteProductById(id);
                    break;
                case 4:
                    System.out.println("Chức năng chỉnh sửa");
                    System.out.print("Nhập mã sản phẩm bạn muốn chỉnh sửa: ");
                    int idEdit = Integer.parseInt(scanner.nextLine());
                    productManager.editProductById(idEdit);
                    break;
                case 5:
                    System.out.println("Chức năng tìm kiếm");
                    System.out.print("Nhập tên bạn muốn tìm: ");
                    String name = scanner.nextLine();
                    List<Product> products = productManager.searchProductByName(name);
                    if(products.isEmpty()) {
                        System.out.println("Tên sản phẩm bạn nhập không tồn tại.");
                    } else {
                        for (Product product : products) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Sắp xếp theo giá");
                    productManager.sortProductByPrice();
                    break;
                case 7:
                    temp = false;
                    break;
                default:
                    System.out.println("Bạn chọn chức năng chưa đúng");
            }
        } while (temp);
    }
}
