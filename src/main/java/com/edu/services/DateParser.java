package com.edu.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateParser {
    
    public static java.sql.Date dateToSqlDate(String date) throws IllegalArgumentException {
        String[] patterns = {
            "dd.MM.yyyy",
        };

        for (String pat: patterns) {
            try {
                return java.sql.Date.valueOf(LocalDate.parse(date, DateTimeFormatter.ofPattern(pat)));
            }
            catch (IllegalArgumentException e) {
            }
        }
        
        throw new IllegalArgumentException(String.format("Invalid Date format passed: [%s]", date));
    }


}
