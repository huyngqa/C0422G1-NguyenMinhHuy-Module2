package ss7_abstract_interface.practice.comparator;

import ss6_inheritance_and_polymorphism.practice.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        return (int) (c1.getRadius() - c2.getRadius());
    }
}
