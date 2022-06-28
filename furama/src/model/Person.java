package model;

import common.FormatDate;

import java.time.LocalDate;

public abstract class Person {
    private String personId;
    private String name;
    private LocalDate dateOfBirth;
    private String sex;
    private String identityCardNumber;
    private String tel;
    private String email;

    public Person() {
    }

    public Person(String personId, String name, LocalDate dateOfBirth, String sex, String identityCardNumber, String tel, String email) {
        this.personId = personId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.identityCardNumber = identityCardNumber;
        this.tel = tel;
        this.email = email;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInformationToCSV() {
        return personId + "," + name + "," + dateOfBirth + "," + sex + "," + identityCardNumber + "," + tel + "," + email;
    }

    @Override
    public String toString() {
        return "Mã id: " + personId + "\n" +
                "Tên: " + name + "\n" +
                "Ngày sinh: " + FormatDate.getDateFormatted(dateOfBirth) + "\n" +
                "Giới tính: " + sex + "\n" +
                "Số CMND: " + identityCardNumber + "\n" +
                "Số điện thoại: " + tel + "\n" +
                "Email: " + email + "\n";
    }
}
