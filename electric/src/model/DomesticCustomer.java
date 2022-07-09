package model;

public class DomesticCustomer extends Customer {
    private String customerType;
    private double consumption;

    public DomesticCustomer() {
    }

    public DomesticCustomer(String customerType, double consumption) {
        this.customerType = customerType;
        this.consumption = consumption;
    }

    public DomesticCustomer(String customerId, String customerName, String customerType, double consumption) {
        super(customerId, customerName);
        this.customerType = customerType;
        this.consumption = consumption;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    @Override
    public String getCustomerToCSV() {
        return super.getCustomerToCSV() + "," + this.customerType + "," + this.consumption;
    }

    @Override
    public String toString() {
        return "Khách hàng trong nước{" +
                super.toString() + "\n" +
                "Loại khách hàng: " + customerType + "\n" +
                "Số lượng tiêu thụ: " + consumption + "\n" +
                "}" + "\n" +
                "-------------------------------------------";
    }
}
