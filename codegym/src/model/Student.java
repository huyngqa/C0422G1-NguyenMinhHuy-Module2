package model;

import common.FormatDate;

import java.time.LocalDate;

public class Student extends Person {
    private double points;
    private String classesName;
    private LocalDate dateOfStudy;

    public Student() {
    }

    public Student(double points, String classesName, LocalDate dateOfStudy) {
        this.points = points;
        this.classesName = classesName;
        this.dateOfStudy = dateOfStudy;
    }

    public Student(String personId, String personName, LocalDate dateOfBirth, String address, String tel, double points, String classesName, LocalDate dateOfStudy) {
        super(personId, personName, dateOfBirth, address, tel);
        this.points = points;
        this.classesName = classesName;
        this.dateOfStudy = dateOfStudy;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public LocalDate getDateOfStudy() {
        return dateOfStudy;
    }

    public void setDateOfStudy(LocalDate dateOfStudy) {
        this.dateOfStudy = dateOfStudy;
    }

    @Override
    public String getInformationPersonToCSV() {
        return super.getInformationPersonToCSV() + "," + points + "," + classesName + "," + dateOfStudy;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() + "\n" +
                "Điểm thi: " + points + "\n" +
                "Tên lớp: " + classesName + "\n" +
                "Ngày nhập học: " + FormatDate.getDateFormatted(dateOfStudy) + "\n" +
                '}' + "\n" +
                "---------------------------------";
    }
}
