package ss6_inheritance_and_polymorphism.excercise.triangle;

import ss6_inheritance_and_polymorphism.practice.Shape;

public class RunTriangle {
    public static void main(String[] args) {
        Shape shape = new Triangle();
        shape.setColor("Red");
        System.out.println(shape);
    }
}
