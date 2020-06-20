package com.mentorCliq.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mentorCliq.model.Employee;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvUtil {

    private CsvUtil() {

        throw new UnsupportedOperationException();
    }

    public static List<Employee> readCsvFile(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Employee.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException("Can not parse provided csv file. " + file.getName());
        }
    }
}
