package com.mentorCliq.model;

import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

public class MatchingCombination {

    private final List<EmployeeMatchPercent> combinations;
    private final double average;

    public MatchingCombination(List<EmployeeMatchPercent> combinations) {
        this.combinations = combinations;
        this.average = computeAverage();
    }

    public List<EmployeeMatchPercent> getCombinations() {
        return combinations;
    }

    public double getAverage() {
        return average;
    }

    private double computeAverage() {
        OptionalDouble maybeAvg = combinations.stream()
                .mapToDouble(EmployeeMatchPercent::getPercent)
                .average();
        if (maybeAvg.isPresent()) {
            return maybeAvg.getAsDouble();
        }

        throw new RuntimeException("Can not calculate an average.");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchingCombination that = (MatchingCombination) o;
        return Double.compare(that.average, average) == 0 &&
                Objects.equals(combinations, that.combinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(combinations, average);
    }

    @Override
    public String toString() {
        return "EmployeesAverage{" +
                "combinations=" + combinations +
                ", average=" + average +
                '}';
    }
}
