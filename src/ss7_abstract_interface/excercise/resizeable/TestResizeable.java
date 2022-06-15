package ss7_abstract_interface.excercise.resizeable;

public class TestResizeable {
    public static void main(String[] args) {
        double percent = Math.floor(Math.random() * 100 + 1) / 100;

        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(4, 6);
        shapes[1] = new Square(4);
        shapes[2] = new Circle(3.5);

        System.out.println("Trước khi thay đổi");
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Diện tích trước khi thay đổi: " + shape.getArea());
        }

        System.out.println();

        System.out.println("Sau khi thay đổi");
        for (Shape shape : shapes) {
            shape.resize(percent);
            System.out.println(shape);
            System.out.println("Diện tích sau khi thay đổi: " + shape.getArea());
        }
    }
}
