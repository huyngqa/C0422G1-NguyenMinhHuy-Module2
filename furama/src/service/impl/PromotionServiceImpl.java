package service.impl;

import model.Booking;
import service.PromotionService;
import util.ReadFurama;

import java.util.Set;

public class PromotionServiceImpl implements PromotionService{
    private final String PATH_FILE_BOOKING = "furama/src/data/booking.csv";
    @Override
    public void displayCustomerUsedFacility() {
        Set<Booking> set = ReadFurama.readBookingToCSV(PATH_FILE_BOOKING);
    }
}
