package model;

public class Bike extends Transport {
    private int wattage;

    public Bike() {
    }

    public Bike(int wattage) {
        this.wattage = wattage;
    }

    public Bike(String seaOfControl, Producer producer, String yearOfProduction, String owner, int wattage) {
        super(seaOfControl, producer, yearOfProduction, owner);
        this.wattage = wattage;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "seaOfControl='" + super.getSeaOfControl() + '\'' +
                ", producerName='" + super.getProducer() + '\'' +
                ", yearOfProduction='" + super.getYearOfProduction() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                "wattage=" + wattage + "hz" +
                '}';
    }
}
