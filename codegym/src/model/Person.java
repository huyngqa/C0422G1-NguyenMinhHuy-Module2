package model;

import common.FormatDate;

import java.time.LocalDate;

public abstract class Person {
    private String personId;
    private String personName;
    private LocalDate dateOfBirth;
    private String address;
    private String tel;

    public Person() {
    }

    public Person(String personId, String personName, LocalDate dateOfBirth, String address, String tel) {
        this.personId = personId;
        this.personName = personName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.tel = tel;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getInformationPersonToCSV() {
        return personId + "," + personName + "," + dateOfBirth + "," + address + "," + tel;
    }

    @Override
    public String toString() {
        return "Mã định danh: " + personId + "\n" +
                "Họ và tên: " + personName + "\n" +
                "Ngày sinh: " + FormatDate.getDateFormatted(dateOfBirth) + "\n" +
                "Địa chỉ: " + address + "\n" +
                "Số điện thoại: " + tel;
    }
}
