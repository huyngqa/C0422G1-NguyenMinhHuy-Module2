package ss5_accessmodifier_staticmethod_staticproperty.practice.static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3", "Skyactiv 3");
        System.out.println(Car.numberOfCar);
        Car car2 = new Car("Mazda 6", "Skyactiv 6");
        System.out.println(Car.numberOfCar);
    }
}
