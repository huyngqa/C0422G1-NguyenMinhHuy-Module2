package ss17_binaryfile_serialization.excercise.product;

public class Product {
    private String productId;
    private String productName;
    private String producer;
    private int price;

    public Product() {
    }

    public Product(String productId, String productName, String producer, int price) {
        this.productId = productId;
        this.productName = productName;
        this.producer = producer;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                '}';
    }
}
