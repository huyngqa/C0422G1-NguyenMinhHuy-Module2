package model;

import java.time.LocalDate;

public class Employee extends Person {
    private String level;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(String level, String position, int salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String personId, String name, LocalDate dateOfBirth, String sex, String identityCardNumber, String tel, String email, String level, String position, int salary) {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getInformationToCSV() {
        return super.getInformationToCSV() + "," + level + "," + position + "," + salary;
    }

    @Override
    public String toString() {
        return "Nhân viên{" +
                super.toString() +
                "Trình độ: " + level + "\n" +
                "Chức vụ: " + position + "\n" +
                "Lương: " + salary +
                "}" + "\n" +
                "---------------------------------------------";
    }
}
