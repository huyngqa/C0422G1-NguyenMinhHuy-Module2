package ss5_accessmodifier_staticmethod_staticproperty.excercise.student;

public class Student {
    private String name = "John";
    private String classes = "CO2";

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String toString() {
        return "Học sinh: " + name + " học lớp: " + classes;
    }
}
