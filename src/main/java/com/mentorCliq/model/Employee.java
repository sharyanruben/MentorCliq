package com.mentorCliq.model;

import java.util.Objects;

import com.opencsv.bean.CsvBindByName;

public class Employee {

    @CsvBindByName
    private String name;
    @CsvBindByName
    private int age;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String division;
    @CsvBindByName
    private int timezone;

    public Employee() {
    }

    public Employee(String name, int age, String email, String division, int timeZone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.division = division;
        this.timezone = timeZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                timezone == employee.timezone &&
                Objects.equals(name, employee.name) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(division, employee.division);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email, division, timezone);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", division='" + division + '\'' +
                ", timeZone=" + timezone +
                '}';
    }
}
