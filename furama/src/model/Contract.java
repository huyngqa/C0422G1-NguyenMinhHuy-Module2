package model;

public class Contract {
    private String contractId;
    private Booking booking;
    private int depositAdvance;
    private int totalPayment;
    private Booking customer;

    public Contract() {
    }

    public Contract(String contractId, Booking booking, int depositAdvance, int totalPayment, Booking customer) {
        this.contractId = contractId;
        this.booking = booking;
        this.depositAdvance = depositAdvance;
        this.totalPayment = totalPayment;
        this.customer = customer;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getDepositAdvance() {
        return depositAdvance;
    }

    public void setDepositAdvance(int depositAdvance) {
        this.depositAdvance = depositAdvance;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Booking getCustomer() {
        return customer;
    }

    public void setCustomer(Booking customer) {
        this.customer = customer;
    }

    public String getInformationToCSV() {
        return contractId + "," + booking.getBookingId() + "," + depositAdvance + "," + totalPayment + "," + booking.getCustomerId().getPersonId();
    }

    @Override
    public String toString() {
        return "Contract{" +
                "Số hợp đồng: " + contractId + "\n" +
                "Mã booking: " + booking.getBookingId() + "\n" +
                "Số tiền cọc trước: " + depositAdvance + "\n" +
                "Tổng tiền thanh toán: " + totalPayment + "\n" +
                "Mã khách hàng: " + booking.getCustomerId().getPersonId() +
                "}" + "\n" +
                "---------------------------------------------";
    }
}
