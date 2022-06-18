package ss6_inheritance_and_polymorphism.excercise.point;

public class TestPoint {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        point2D.setXY(1, 3);
        System.out.println(point2D);

        Point3D point3D = new Point3D();
        point3D.setXYZ(point2D.getX(), point2D.getY(), 5);
        System.out.println(point3D);
    }
}
