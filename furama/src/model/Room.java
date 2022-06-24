package model;

import java.time.LocalDateTime;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String nameService, double usableArea, double rentalCosts, int maximumNumOfPeople, String rentalType, String freeService) {
        super(nameService, usableArea, rentalCosts, maximumNumOfPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "Dịch vụ miễn phí đi kèm: " + freeService +
                '}';
    }
}
