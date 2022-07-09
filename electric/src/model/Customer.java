package model;

public abstract class Customer {
    private String customerId;
    private String customerName;

    public Customer() {
    }

    public Customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerToCSV() {
        return this.customerId + "," + this.customerName;
    }
    @Override
    public String toString() {
        return "Mã khách hàng: " + customerId + "\n" +
                "Tên khách hàng: " + customerName;
    }
    public static int a() {
        return 1;
    }
}
