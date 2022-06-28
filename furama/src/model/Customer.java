package model;

import java.time.LocalDate;

public class Customer extends Person {
    private String typeCustomer;
    private String address;

    public Customer() {
    }

    public Customer(String typeCustomer, String address) {
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public Customer(String personId, String name, LocalDate dateOfBirth, String sex, String identityCardNumber, String tel, String email, String typeCustomer, String address) {
        super(personId, name, dateOfBirth, sex, identityCardNumber, tel, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInformationToCSV() {
        return super.getInformationToCSV() + "," + typeCustomer + "," + address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "Loại khách: " + typeCustomer + "\n" +
                "Địa chỉ: " + address +
                '}' + "\n" +
                "-----------------------------------";
    }
}
