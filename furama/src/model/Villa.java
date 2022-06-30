package model;

public class Villa extends Facility {
    private String roomStandard;
    private double swimmingPoolArea;
    private int numOfFloor;

    public Villa() {
    }

    public Villa(String roomStandard, double swimmingPoolArea, int numOfFloor) {
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numOfFloor = numOfFloor;
    }

    public Villa(String facilityId, String nameService, double usableArea, double rentalCosts, int maximumNumOfPeople, String rentalType, String roomStandard, double swimmingPoolArea, int numOfFloor) {
        super(facilityId, nameService, usableArea, rentalCosts, maximumNumOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numOfFloor = numOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    public String getInformationToCSV() {
        return super.getInformationToCSV() + "," + roomStandard + "," + swimmingPoolArea + "," + numOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "Tiêu chuẩn phòng: " + roomStandard + "\n" +
                "Diện tích hồ bơi: " + swimmingPoolArea + "\n" +
                "Số tầng: " + numOfFloor +
                "}" + "\n" +
                "---------------------------------------------";
    }
}
