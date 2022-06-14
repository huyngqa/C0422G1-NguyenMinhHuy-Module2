package ss6_inheritance_and_polymorphism.excercise.cricle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.pow(super.getRadius(), 2) * Math.PI * height;
    }

    @Override
    public String toString() {
        return "Bán kính: " + super.getRadius() + "\n"
                + "Màu sắc: " + super.getColor() + "\n"
                + "Chiều cao: " + height + "\n"
                + "Thể tích: " + getVolume() +"\n";
    }
}
