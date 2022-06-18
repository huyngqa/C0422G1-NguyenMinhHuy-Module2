package ss6_inheritance_and_polymorphism.excercise.cricle;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }
    @Override
    public String toString() {
        return "Bán kính: " + radius + "\n"
                + "Màu sắc: " + color + "\n"
                + "Diện tích: " + getArea() + "\n";
    }
}
