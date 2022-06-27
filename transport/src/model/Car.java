package model;

public class Car extends Transport {
    private int numOfSeats;
    private String vehicleType;

    public Car() {
    }

    public Car(int numOfSeats, String vehicleType) {
        this.numOfSeats = numOfSeats;
        this.vehicleType = vehicleType;
    }

    public Car(String seaOfControl, Producer producer, String yearOfProduction, String owner, int numOfSeats, String vehicleType) {
        super(seaOfControl, producer, yearOfProduction, owner);
        this.numOfSeats = numOfSeats;
        this.vehicleType = vehicleType;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }


    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String getInformationToCSV() {
        return super.getInformationToCSV() + "," + numOfSeats + "," + vehicleType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seaOfControl='" + super.getSeaOfControl() + '\'' +
                ", producerName='" + super.getProducer().getProducerName() + '\'' +
                ", yearOfProduction='" + super.getYearOfProduction() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                "numOfSeats=" + numOfSeats +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
