package com.mallickdgp;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CheckGivenDaysOccurBetween2DatesTest {


    @Test
    public void test_givenDaysOccurBetweenDates(){
        String fromDate = "2021-06-12";
        String toDate = "2021-06-18";

        List<String> givenDays = Arrays.asList("MONDAY", "WEDNESDAY", "SUNDAY");

        assertTrue(CheckGivenDaysOccurBetween2Dates.solution(fromDate, toDate, givenDays));

    }
}
