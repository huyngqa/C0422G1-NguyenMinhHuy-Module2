package model;

public class Contract {
    private String contractId;
    private Booking bookingId;
    private double depositAdvance;
    private double totalPayment;
    private Customer customerId;

    public Contract() {
    }

    public Contract(String contractId, Booking bookingId, double depositAdvance, double totalPayment, Customer customerId) {
        this.contractId = contractId;
        this.bookingId = bookingId;
        this.depositAdvance = depositAdvance;
        this.totalPayment = totalPayment;
        this.customerId = customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Booking getBookingId() {
        return bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public double getDepositAdvance() {
        return depositAdvance;
    }

    public void setDepositAdvance(double depositAdvance) {
        this.depositAdvance = depositAdvance;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "Số hợp đồng: " + contractId + "\n" +
                "Mã booking: " + bookingId.getBookingId() + "\n" +
                "Số tiền cọc trước: " + depositAdvance + "\n" +
                "Tổng tiền thanh toán: " + totalPayment + "\n" +
                "Mã khách hàng: " + customerId.getPersonId() +
                "}" + "\n" +
                "---------------------------------------------";
    }
}
