package model;

public class Producer {
    private int id;
    private String producerName;
    private String country;

    public Producer() {
    }

    public Producer(int id, String producerName, String country) {
        this.id = id;
        this.producerName = producerName;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInformationToCSV() {
        return id + "," + producerName + "," + country;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", producerName='" + producerName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
