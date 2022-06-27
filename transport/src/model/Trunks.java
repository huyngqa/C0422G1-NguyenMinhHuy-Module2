package model;

public class Trunks extends Transport {
    private float tonnage;

    public Trunks() {
    }

    public Trunks(float tonnage) {
        this.tonnage = tonnage;
    }

    public Trunks(String seaOfControl, Producer producer, String yearOfProduction, String owner, float tonnage) {
        super(seaOfControl, producer, yearOfProduction, owner);
        this.tonnage = tonnage;
    }

    public float getTonnage() {
        return tonnage;
    }

    public void setTonnage(float tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String getInformationToCSV() {
        return super.getInformationToCSV() + "," + tonnage;
    }

    @Override
    public String toString() {
        return "Trunks{" +
                "seaOfControl='" + super.getSeaOfControl() + '\'' +
                ", producerName='" + super.getProducer().getProducerName() + '\'' +
                ", yearOfProduction='" + super.getYearOfProduction() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                "tonnage=" + tonnage +
                '}';
    }
}
