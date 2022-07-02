package model;

import java.util.Objects;

public abstract class Facility {
    private String facilityId;
    private String nameService;
    private double usableArea;
    private int rentalCosts;
    private int maximumNumOfPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String facilityId, String nameService, double usableArea, int rentalCosts, int maximumNumOfPeople, String rentalType) {
        this.facilityId = facilityId;
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maximumNumOfPeople = maximumNumOfPeople;
        this.rentalType = rentalType;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaximumNumOfPeople() {
        return maximumNumOfPeople;
    }

    public void setMaximumNumOfPeople(int maximumNumOfPeople) {
        this.maximumNumOfPeople = maximumNumOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return nameService.equals(facility.nameService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameService);
    }

    public String getInformationToCSV() {
        return facilityId + "," + nameService + "," + usableArea + "," + rentalCosts + "," + maximumNumOfPeople + "," + rentalType;
    }

    @Override
    public String toString() {
        return  "Mã dịch vụ: " + facilityId + "\n"
                + "Tên dịch vụ: " + nameService + "\n"
                + "Diện tích: " + usableArea + "\n"
                + "Chi phí thuê: " + rentalCosts + "\n"
                + "Số lượng người tối đa: " + maximumNumOfPeople + "\n"
                + "Kiểu thuê: " + rentalType + "\n";
    }
}
