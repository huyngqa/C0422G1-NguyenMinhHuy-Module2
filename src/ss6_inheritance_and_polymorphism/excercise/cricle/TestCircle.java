package ss6_inheritance_and_polymorphism.excercise.cricle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle  = new Circle(3.5, "đỏ");
        System.out.println(circle);

        Cylinder cylinder = new Cylinder(3.5, "xanh lá", 3.5);
        System.out.println(cylinder);
    }
}
