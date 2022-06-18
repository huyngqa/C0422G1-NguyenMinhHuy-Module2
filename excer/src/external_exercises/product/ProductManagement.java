package external_exercises.product;

import java.util.Scanner;

public class ProductManagement {
    static Product[] products = new Product[100];
    static Scanner scanner = new Scanner(System.in);

    static {
        products[0] = new Product(1, "kem", "ĐN", 3, 10000);
        products[1] = new Product(2, "snack", "ĐN", 6, 5000);
        products[2] = new Product(3, "candy", "ĐN", 3, 2000);
    }

    public void display() {
        for (int i = 0; i < Product.count; i++) {
            System.out.println(products[i]);
        }
    }

    public void editProductByName(String name) {
        String result = "";
        for (int i = 0; i < Product.count; i++) {
            if (name.equals(products[i].getName())) {
                products[i].setId(Integer.parseInt(scanner.nextLine()));
                products[i].setName(scanner.nextLine());
                products[i].setProductLocation(scanner.nextLine());
                products[i].setNumOfProduct(Integer.parseInt(scanner.nextLine()));
                products[i].setPrice(Integer.parseInt(scanner.nextLine()));
                System.out.println("Đã chỉnh sửa thành công");
                break;
            } else {
                result = "Tên sản phẩm không tồn tại";
            }
        }
        System.out.println(result);
    }

    public void addProduct() {
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                System.out.print("Nhập mã sản phẩm: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập địa điểm sản xuất: ");
                String location = scanner.nextLine();
                System.out.print("Nhập số lượng sản phẩm: ");
                int count = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập giá sản phẩm: ");
                int price = Integer.parseInt(scanner.nextLine());
                Product product = new Product(id, name, location, count, price);
                products[i] = product;
                break;
            } else if (name.equals(products[i].getName())) {
                System.out.print("Sản phẩm đã có, mời bạn nhập thêm số lượng: ");
                int temp = Integer.parseInt(scanner.nextLine());
                products[i].setNumOfProduct(temp + products[i].getNumOfProduct());
                break;
            }
        }
        System.out.println("Đã thêm thành công");
    }

    public void deleteProduct(int id) {
        String result = "";
        for (int i = 0; i < Product.count; i++) {
            if (products[i].getId() == id) {
                for (int j = i; j < products.length - 1; j++) {
                    products[j] = products[j + 1];
                }
                Product.count--;
                result = "Đã xoá thành công";
                break;
            } else {
                result = "Không thấy id";
            }
        }
        System.out.println(result);
    }
    public void searchByName(String name) {
        for (int i = 0; i < Product.count; i++) {
            if(products[i].getName().equalsIgnoreCase(name)) {
                System.out.println(products[i]);
            }
        }
    }
}
