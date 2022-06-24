package model;

import java.time.LocalDateTime;

public class House extends Facility {
    private String roomStandard;
    private byte numOfFloor;

    public House() {
    }

    public House(String roomStandard, byte numOfFloor) {
        this.roomStandard = roomStandard;
        this.numOfFloor = numOfFloor;
    }

    public House(String nameService, double usableArea, double rentalCosts, int maximumNumOfPeople, String rentalType, String roomStandard, byte numOfFloor) {
        super(nameService, usableArea, rentalCosts, maximumNumOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numOfFloor = numOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public byte getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(byte numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                "Tiêu chuẩn phòng: " + roomStandard + "\n" +
                "Số tầng: " + numOfFloor +
                '}';
    }
}
