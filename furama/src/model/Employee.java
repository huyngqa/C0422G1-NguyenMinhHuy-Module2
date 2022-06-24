package model;

import java.time.LocalDate;

public class Employee extends Person {
    private String level;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String level, String position, double salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String personId, String name, LocalDate dateOfBirth, String sex, String identityCardNumber, String tel, String email, String level, String position, double salary) {
        super(personId, name, dateOfBirth, sex, identityCardNumber, tel, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Nhân viên{" +
                super.toString() +
                "Trình độ: " + level + "\n" +
                "Chức vụ: " + position + "\n" +
                "Lương: " + salary +
                '}';
    }
}
