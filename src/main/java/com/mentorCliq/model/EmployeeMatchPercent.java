package com.mentorCliq.model;

import java.util.Objects;

public class EmployeeMatchPercent {

    private Employee employee1;
    private Employee employee2;
    private float percent;

    public EmployeeMatchPercent() {
    }

    public EmployeeMatchPercent(Employee employee1, Employee employee2, float percent) {
        this.employee1 = employee1;
        this.employee2 = employee2;
        this.percent = percent;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeMatchPercent that = (EmployeeMatchPercent) o;
        return Float.compare(that.percent, percent) == 0 &&
                Objects.equals(employee1, that.employee1) &&
                Objects.equals(employee2, that.employee2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee1, employee2, percent);
    }

    @Override
    public String toString() {
        return "EmployeeMatchPercent{" +
                "employee1=" + employee1 +
                ", employee2=" + employee2 +
                ", percent=" + percent +
                '}';
    }
}
