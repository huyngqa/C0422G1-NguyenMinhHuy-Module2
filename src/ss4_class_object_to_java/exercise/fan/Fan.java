package ss4_class_object_to_java.exercise.fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 1;

    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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

    public String toString() {
        if (this.isOn()) {
            return "Tốc độ quạt: " + this.speed + ", quạt có màu: " + this.color
                    + ", có bán kính: " + this.radius + ", và quạt đang chạy";
        } else {
            return "Quạt có màu: " + this.color
                    + ", có bán kính: " + this.radius + ", và quạt đang tắt";
        }
    }
}
