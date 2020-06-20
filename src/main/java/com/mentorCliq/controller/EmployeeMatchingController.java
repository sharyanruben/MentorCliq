package com.mentorCliq.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mentorCliq.model.Employee;
import com.mentorCliq.model.MatchingCombination;
import com.mentorCliq.service.EmployeeService;
import com.mentorCliq.service.RecommendedService;
import com.mentorCliq.util.CsvUtil;


@Controller
public class EmployeeMatchingController {

    private final EmployeeService employeeService;
    private final RecommendedService recommendedService;

    public EmployeeMatchingController(EmployeeService employeeService, RecommendedService recommendedService) {
        this.employeeService = employeeService;
        this.recommendedService = recommendedService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("upload-csv-file")
    public String uploadCsvFile(@RequestParam(name = "file", value = "file") MultipartFile file, Model model) {

        if (file != null) {
            List<Employee> employees = CsvUtil.readCsvFile(file);
            List<MatchingCombination> matchingCombinations = employeeService.getMatchingCombinations(employees);
            List<MatchingCombination> rec = recommendedService.getRecommendedCombinations(matchingCombinations);
            model.addAttribute("matchingCombinations", matchingCombinations);
            model.addAttribute("recommended", rec);
            model.addAttribute("status", true);
        }

        return "recommendedPage";

    }
}
