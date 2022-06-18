package ss8_cleancode_refactoring.practice;

public class Cylinder {
    public static double getVolume(int radius, int height) {
        return getPerimeter(radius) * height  + 2 * getBaseArea(radius);
    }

    private static double getPerimeter(int radius) {
        return 2 * Math.PI * radius;
    }

    private static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }
}
