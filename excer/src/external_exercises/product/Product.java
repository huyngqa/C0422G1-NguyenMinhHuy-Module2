package external_exercises.product;

public class Product {
    private int id;
    private String name;
    private String productLocation;
    private int numOfProduct;
    private int price;
    public static int count = 0;

    public Product() {
    }

    public Product(int id, String name, String productLocation, int numOfProduct, int price) {
        this.id = id;
        this.name = name;
        this.productLocation = productLocation;
        this.numOfProduct = numOfProduct;
        this.price = price;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
    }

    public int getNumOfProduct() {
        return numOfProduct;
    }

    public void setNumOfProduct(int numOfProduct) {
        this.numOfProduct = numOfProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productLocation='" + productLocation + '\'' +
                ", numOfProduct=" + numOfProduct +
                ", price=" + price +
                '}';
    }
}
