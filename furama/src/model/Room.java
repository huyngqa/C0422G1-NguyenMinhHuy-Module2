package model;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String facilityId, String nameService, double usableArea, int rentalCosts, int maximumNumOfPeople, String rentalType, String freeService) {
        super(facilityId, nameService, usableArea, rentalCosts, maximumNumOfPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public String getInformationToCSV() {
        return super.getInformationToCSV() + "," + freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "Dịch vụ miễn phí đi kèm: " + freeService +
                "}" + "\n" +
                "---------------------------------------------";
    }
}
