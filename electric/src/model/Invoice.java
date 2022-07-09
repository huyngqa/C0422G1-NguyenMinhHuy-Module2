package model;

import common.FormatDate;

import java.time.LocalDate;

public class Invoice {
    private String invoiceId;
    private Customer customerId;
    private LocalDate invoicePrintDate;
    private double amountOfConsumption;
    private double unitPrice;
    private double totalPrice;

    public Invoice() {
    }

    public Invoice(String invoiceId, Customer customerId, LocalDate invoicePrintDate, double amountOfConsumption, double unitPrice, double totalPrice) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.invoicePrintDate = invoicePrintDate;
        this.amountOfConsumption = amountOfConsumption;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public LocalDate getInvoicePrintDate() {
        return invoicePrintDate;
    }

    public void setInvoicePrintDate(LocalDate invoicePrintDate) {
        this.invoicePrintDate = invoicePrintDate;
    }

    public double getAmountOfConsumption() {
        return amountOfConsumption;
    }

    public void setAmountOfConsumption(double amountOfConsumption) {
        this.amountOfConsumption = amountOfConsumption;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getInvoiceToCSV() {
        return invoiceId + "," + customerId.getCustomerId() + "," + invoicePrintDate + ","
                + amountOfConsumption + "," + unitPrice + "," + totalPrice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "Mã hoá đơn: " + invoiceId + "\n" +
                "Tên khách hàng: " + customerId.getCustomerName() + "(" + customerId.getCustomerId() + ")" + "\n" +
                "Ngày in hoá đơn: " + FormatDate.getDateFormatted(invoicePrintDate) + "\n" +
                "Số lượng tiêu thụ: " + amountOfConsumption + "\n" +
                "Đơn giá: " + unitPrice + "\n" +
                "Thành tiền: " + totalPrice + "\n" +
                "}" + "\n" +
                "---------------------------------------------";
    }
}
