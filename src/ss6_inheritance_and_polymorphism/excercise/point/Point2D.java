package ss6_inheritance_and_polymorphism.excercise.point;

public class Point2D {
    private float x;
    private float y;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] arrays = new float[2];
        arrays[0] = x;
        arrays[1] = y;
        return arrays;
    }

    @Override
    public String toString() {
        return "Point2D" + "\n" +
                "Toạ độ x: " + x + "\n" +
                "Toạ độ y: " + y + "\n";
    }
}
