package ss5_accessmodifier_staticmethod_staticproperty.practice.static_method;

public class Student {
    private int roll;
    private String name;
    private static String college = "BBDIT";

    public Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    static void change() {
        college = "CODEGYM";
    }
    void display() {
        System.out.println(roll + " " + name + " " + college);
    }
}
