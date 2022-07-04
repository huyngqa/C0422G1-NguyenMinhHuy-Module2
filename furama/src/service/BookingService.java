package service;

import model.Booking;

public interface BookingService extends Service {
    Booking getBookingById();
}
