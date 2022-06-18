package external_exercises.product;

import java.util.Scanner;

public class RunProduct {
    public static void main(String[] args) {
        displayMenu();
    }
    public static void displayMenu() {
        ProductManagement management = new ProductManagement();
        boolean flag = true;
        do {
            System.out.println("\nChức năng của hệ thống " +
                    "\n 1. Hiển thị danh sách sản phẩm" +
                    "\n 2. Thêm sản phẩm" +
                    "\n 3. Chỉnh sửa sản phẩm" +
                    "\n 4. Xoá sản phẩm" +
                    "\n 5. Tìm kiếm sản phẩm" +
                    "\n 6. Thoát khỏi chương trình");
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nChọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Hiển thị danh sách sản phẩm.");
                    management.display();
                    break;
                case 2:
                    System.out.println("Chức năng thêm sản phẩm.");
                    management.addProduct();
                    break;
                case 3:
                    System.out.println("Chức năng chỉnh sửa sản phẩm.");
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    management.editProductByName(name);
                    break;
                case 4:
                    System.out.println("Chức năng xoá sản phẩm.");
                    System.out.print("Nhập mã sản phẩm: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    management.deleteProduct(id);
                    System.out.print("Nhập tên sản phẩm bạn muốn tìm: ");
                    break;
                case 5:
                    System.out.println("Chức năng tìm kiếm sản phẩm.");
                    name = scanner.nextLine();
                    management.searchByName(name);
                    break;
                case 6:
                    flag = false;
                    System.out.println("Bạn đã thoát khỏi chương trình!");
                    break;
                default:
                    System.out.println("Bạn nhập chức năng không chính x ác");
            }
        } while (flag);
    }
}
