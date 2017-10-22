package ru.people_registration.data_filters;

import java.util.Date;
import ru.people_registration.beans.Street;

public class PersonFilter {
    private String surname;
    private String name;
    private String patronymic;
    private Boolean sex;
    private Date dateBirthdayMin;
    private Date dateBirthdayMax;
    private Street street;
    private Integer buildingNum;

    public PersonFilter() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("setSurname: " + surname);
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDateBirthdayMin() {
        return dateBirthdayMin;
    }

    public void setDateBirthdayMin(Date dateBirthdayMin) {
        this.dateBirthdayMin = dateBirthdayMin;
    }

    public Date getDateBirthdayMax() {
        return dateBirthdayMax;
    }

    public void setDateBirthdayMax(Date dateBirthdayMax) {
        this.dateBirthdayMax = dateBirthdayMax;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Integer getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(Integer buildingNum) {
        this.buildingNum = buildingNum;
    }

    @Override
    public String toString() {
        return "StreetFilter{" + "surname=" + surname + ", name=" + name + ", patronymic=" + patronymic + ", sex=" + sex + ", dateBirthdayMin=" + dateBirthdayMin + ", dateBirthdayMax=" + dateBirthdayMax + ", street=" + street + ", buildingNum=" + buildingNum + '}';
    }
}
