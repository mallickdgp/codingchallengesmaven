package com.mallickdgp;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CheckGivenDaysOccurBetween2Dates{

    public static boolean solution(String fromDate, String toDate, List<String> givenDays){
        LocalDate startDate = LocalDate.parse(fromDate);
        LocalDate endDate = LocalDate.parse(toDate);
        final List<String> daysInBetween = new ArrayList<>();
        startDate.datesUntil(endDate).forEach(
                lDate -> daysInBetween.add(DayOfWeek.of(lDate.getDayOfWeek().getValue()).toString())
        );
        boolean dayIsPresent = false;
        for(String day: givenDays){

            dayIsPresent = daysInBetween.contains(day);
            if(!dayIsPresent)
                break;
        }
        System.out.println(startDate.getDayOfWeek());
        System.out.println(endDate.getDayOfWeek());
        return dayIsPresent;
    }
}
