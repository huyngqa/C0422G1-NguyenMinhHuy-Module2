package model;

import java.time.LocalDate;

public class Employee extends Person {
    private int salary;
    private String room;
    private String position;

    public Employee() {
    }

    public Employee(int salary, String room, String position) {
        this.salary = salary;
        this.room = room;
        this.position = position;
    }

    public Employee(String personId, String personName, LocalDate dateOfBirth, String address, String tel, int salary, String room, String position) {
        super(personId, personName, dateOfBirth, address, tel);
        this.salary = salary;
        this.room = room;
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getInformationPersonToCSV() {
        return super.getInformationPersonToCSV() + "," + salary + "," + room + "," + position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() + "\n" +
                "Lương: " + salary + "\n" +
                "Phòng ban: " + room + "\n" +
                "Vị trí: " + position + "\n" +
                '}' + "\n" +
                "---------------------------------";
    }
}
