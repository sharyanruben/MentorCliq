package com.mentorCliq.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mentorCliq.model.Employee;
import com.mentorCliq.model.EmployeeMatchPercent;
import com.mentorCliq.model.MatchingCombination;
import com.mentorCliq.util.PercentComputeUtil;

import javax.validation.constraints.NotEmpty;

@Service
public class EmployeeService {


    public List<MatchingCombination> getMatchingCombinations(List<Employee> employeesList) {
        int halfSize = employeesList.size() / 2;

        int employeesLength = employeesList.size() - 1;

        List<MatchingCombination> matchingCombinations = new ArrayList<>();

        for (int i = 0; i < employeesLength; i++) {

            List<EmployeeMatchPercent> employeeMatchPercentList = new ArrayList<>();
            for (int j = 0; j < halfSize; j++) {
                int firstEmployeeIndex = (i + j) % employeesLength;
                int secondEmployeeIndex = (i + employeesLength - j) % employeesLength;
                if (firstEmployeeIndex == secondEmployeeIndex) {
                    secondEmployeeIndex = employeesLength;
                }
                Employee firstEmployee = employeesList.get(firstEmployeeIndex);
                Employee secondEmployee = employeesList.get(secondEmployeeIndex);

                employeeMatchPercentList.add(compareEmployeesMatching(firstEmployee, secondEmployee));
            }
            matchingCombinations.add(new MatchingCombination(employeeMatchPercentList));
        }
        return matchingCombinations;
    }


    private EmployeeMatchPercent compareEmployeesMatching(Employee employee1, Employee employee2) {
        EmployeeMatchPercent employeeMatchPercent = new EmployeeMatchPercent();
        employeeMatchPercent.setEmployee1(employee1);
        employeeMatchPercent.setEmployee2(employee2);
        employeeMatchPercent.setPercent(PercentComputeUtil.getMatchingPercent(employee1, employee2));
        return employeeMatchPercent;
    }

}
