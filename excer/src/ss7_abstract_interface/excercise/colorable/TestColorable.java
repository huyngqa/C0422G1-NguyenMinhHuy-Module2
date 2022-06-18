package ss7_abstract_interface.excercise.colorable;

import ss7_abstract_interface.excercise.resizeable.*;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(4);
        shapes[1] = new Circle(3.5);
        shapes[2] = new Rectangle(2,6);

        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Hình " + (i + 1) +" diện tích là: " + shapes[0].getArea());
            if(shapes[i] instanceof IColorable) {
                ((Square) shapes[i]).howToColor();
            }
        }
    }
}
