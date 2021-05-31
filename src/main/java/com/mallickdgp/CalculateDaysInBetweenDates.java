package com.mallickdgp;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class CalculateDaysInBetweenDates {

    public static HashSet<Integer> solution(Date startDate, Date endDate){
        Calendar beginCalendar = Calendar.getInstance();
        Calendar finishCalendar = Calendar.getInstance();

        beginCalendar.setTime(startDate);
        finishCalendar.setTime(endDate);

        HashSet<Integer> result = new HashSet<>();

        while(beginCalendar.before(finishCalendar)){
            System.out.println(beginCalendar.get(Calendar.DAY_OF_MONTH));
            result.add(beginCalendar.get(Calendar.DAY_OF_MONTH));

            beginCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println(finishCalendar.get(Calendar.DAY_OF_MONTH));
        result.add(finishCalendar.get(Calendar.DAY_OF_MONTH));

        return result;
    }
}
