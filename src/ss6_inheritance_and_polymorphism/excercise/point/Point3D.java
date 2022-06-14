package ss6_inheritance_and_polymorphism.excercise.point;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }
    public float[] getXYZ() {
        float[] arrays = new float[3];
        arrays[0] = super.getX();
        arrays[1] = super.getY();
        arrays[2] = z;
        return arrays;
    }

    @Override
    public String toString() {
        return "Point3D \n" +
                "Toạ độ x: " + super.getX() + "\n" +
                "Toạ độ y: " + super.getY() + "\n" +
                "Toạ độ z: " + z + "\n";
    }
}
