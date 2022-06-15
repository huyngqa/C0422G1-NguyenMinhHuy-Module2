package ss7_abstract_interface.excercise.resizeable;

import ss7_abstract_interface.excercise.colorable.IColorable;

public class Square extends Rectangle implements IResizeable, IColorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        setSide(getSide() + getSide() * percent);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
