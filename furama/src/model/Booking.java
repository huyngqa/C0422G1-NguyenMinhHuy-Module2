package model;

import common.FormatDate;

import java.time.LocalDate;

public class Booking implements Comparable<Booking> {
    private String bookingId;
    private LocalDate startDay;
    private LocalDate endDay;
    private Customer customerId;
    private Facility nameService;

    public Booking() {
    }

    public Booking(String bookingId, LocalDate startDay, LocalDate endDay, Customer customerId, Facility nameService) {
        this.bookingId = bookingId;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerId = customerId;
        this.nameService = nameService;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Facility getNameService() {
        return nameService;
    }

    public void setNameService(Facility nameService) {
        this.nameService = nameService;
    }

    public String getInformationToCSV() {
        return bookingId + "," + startDay + "," + endDay + "," + customerId.getPersonId() + "," + nameService.getNameService();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Mã booking" + bookingId + "\n" +
                "Ngày bắt đầu: " + FormatDate.getDateFormatted(startDay) + "\n" +
                "Ngày kết thúc: " + FormatDate.getDateFormatted(endDay) + "\n" +
                "Mã khách hàng: " + customerId.getPersonId() + "\n" +
                "Tên dịch vụ: " + nameService.getNameService() +
                "}" + "\n" +
                "---------------------------------------------";
    }

    @Override
    public int compareTo(Booking b) {
        if(this.startDay.compareTo(b.getStartDay()) > 1) {
            return 1;
        } else if (this.startDay.compareTo(b.getStartDay())==0) {
            return this.endDay.compareTo(b.getEndDay());
        } else {
            return -1;
        }
    }
}
