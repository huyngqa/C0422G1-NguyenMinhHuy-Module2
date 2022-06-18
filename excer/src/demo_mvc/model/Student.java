package demo_mvc.model;

public class Student extends Person {
    private String className;

    public Student() {
    }

    public Student(int id, String name, String className) {
        super(id, name);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + super.getId() + '\'' +
                "name='" + super.getName() + '\'' +
                "className='" + className + '\'' +
                '}';
    }
}
