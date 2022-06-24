package model;

public abstract class Transport {
    private String seaOfControl;
    private Producer producer;
    private String yearOfProduction;
    private String owner;

    public Transport() {
    }

    public Transport(String seaOfControl, Producer producer, String yearOfProduction, String owner) {
        this.seaOfControl = seaOfControl;
        this.producer = producer;
        this.yearOfProduction = yearOfProduction;
        this.owner = owner;
    }

    public String getSeaOfControl() {
        return seaOfControl;
    }

    public void setSeaOfControl(String seaOfControl) {
        this.seaOfControl = seaOfControl;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "seaOfControl='" + seaOfControl + '\'' +
                ", producerName='" + producer + '\'' +
                ", yearOfProduction='" + yearOfProduction + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
