package model;

public class OverseasCustomers extends Customer {
    private String nationality;

    public OverseasCustomers() {
    }

    public OverseasCustomers(String nationality) {
        this.nationality = nationality;
    }

    public OverseasCustomers(String customerId, String customerName, String nationality) {
        super(customerId, customerName);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String getCustomerToCSV() {
        return super.getCustomerToCSV() + "," +this.nationality;
    }

    @Override
    public String toString() {
        return "OverseasCustomers{" +
                super.toString() + "\n" +
                "Quốc tịch: " + this.nationality + "\n" +
                "}" + "\n" +
                "-------------------------------------------";
    }
}
