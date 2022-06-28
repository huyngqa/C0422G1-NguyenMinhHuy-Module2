package ss17_binaryfile_serialization.excercise.product.service.impl;

import ss17_binaryfile_serialization.excercise.product.model.Product;
import ss17_binaryfile_serialization.excercise.product.service.IService;
import ss17_binaryfile_serialization.excercise.product.util.ReadAndWrite;

import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements IService {
    private final String PATH_FILE_PRODUCT = "excer/src/ss17_binaryfile_serialization/excercise/product/data/product.dat";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        List<Product> products = ReadAndWrite.readObjectToListProduct(PATH_FILE_PRODUCT);
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String producer = scanner.nextLine();
        int price;
        while (true) {
            try {
                System.out.print("Nhập giá sản phẩm: ");
                price = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!");
            }
        }
        products.add(new Product(id, name, producer, price));
        System.out.println("Bạn đã thêm sản phẩm: " + name);
        ReadAndWrite.writeObjectToListProduct(PATH_FILE_PRODUCT, products);
    }

    @Override
    public void display() {
        List<Product> products = ReadAndWrite.readObjectToListProduct(PATH_FILE_PRODUCT);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void findProductById(String productId) {
        List<Product> products = ReadAndWrite.readObjectToListProduct(PATH_FILE_PRODUCT);
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProductId().equalsIgnoreCase(productId)) {
                System.out.println("Đã tìm thấy thông tin");
                System.out.println(products.get(i));
                return;
            }
        }
        System.out.println("Mã sản phẩm bạn muốn tìm không tồn tại!");
    }
}
