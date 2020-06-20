package com.mentorCliq.util;

import com.mentorCliq.model.Employee;

public class PercentComputeUtil {
    private static int ageRequiredPercent = PropertiesUtil.readPropertiesFileByKey(RequiredPropertiesName.AGE.getValue());
    private static int divisionRequiredPercent = PropertiesUtil.readPropertiesFileByKey(RequiredPropertiesName.DIVISION.getValue());
    private static int timezoneRequiredPercent = PropertiesUtil.readPropertiesFileByKey(RequiredPropertiesName.TIMEZONE.getValue());

    private PercentComputeUtil() {
        throw new UnsupportedOperationException();
    }

    public static float getMatchingPercent(Employee employee1, Employee employee2) {

        int percent = 0;
        int ageDiff = employee1.getAge() - employee2.getAge();
        if ((Math.abs(ageDiff)) <= 5) {
            percent += ageRequiredPercent;
        }
        if (employee1.getDivision().equalsIgnoreCase(employee2.getDivision())) {
            percent += divisionRequiredPercent;
        }
        if (employee1.getTimezone() == employee2.getTimezone()) {
            percent += timezoneRequiredPercent;
        }
        return percent;
    }
}
