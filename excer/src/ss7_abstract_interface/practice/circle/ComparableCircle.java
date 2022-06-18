package ss7_abstract_interface.practice.circle;

import ss6_inheritance_and_polymorphism.practice.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        return (int) (this.getRadius() - o.getRadius());
    }
}
