package ss12_java_collection_framwework.excercise.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    static List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    static {
        products.add(new Product(1, "snack", 2000));
        products.add(new Product(2, "candy", 1500));
        products.add(new Product(3, "cream", 3000));
    }

    public void addProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        int price = Integer.parseInt(scanner.nextLine());
        products.add(new Product(id, productName, price));
    }

    public void displayProduct() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public void editProductById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProductId() == id) {
                System.out.print("Sửa mã sản phẩm: ");
                products.get(i).setProductId(Integer.parseInt(scanner.nextLine()));
                System.out.print("Sửa tên sản phẩm: ");
                products.get(i).setProductName(scanner.nextLine());
                System.out.print("Sửa giá sản phẩm: ");
                products.get(i).setPrice(Integer.parseInt(scanner.nextLine()));
                return;
            }
        }
        System.out.println("Mã sản phẩm bạn nhập không đúng");
    }
    public void deleteProductById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProductId() == id) {
                products.remove(products.get(i));
                System.out.println("Bạn đã xoá thành công");
                return;
            }
        }
        System.out.println("Mã sản phẩm bạn nhập không đúng");
    }
    public List<Product> searchProductByName(String productName) {
        List<Product> searchProducts = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equalsIgnoreCase(productName)) {
                searchProducts.add(products.get(i));
            }
        }
        return searchProducts;
    }
    public void sortProductByPrice() {
        Collections.sort(products);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
