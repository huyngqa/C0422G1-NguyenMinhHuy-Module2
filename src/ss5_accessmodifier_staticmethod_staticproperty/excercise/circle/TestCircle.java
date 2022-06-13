package ss5_accessmodifier_staticmethod_staticproperty.excercise.circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Bán kính là: " + circle.getRadius());
        System.out.println("Diện tích là: " + circle.getArea());
    }
}
