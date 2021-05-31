package com.mallickdgp;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateDaysInBetweenDatesTest {

    @Test
    public void test_UC01TC01() throws Exception{
        Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse("27/05/2021");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse("05/06/2021");

        CalculateDaysInBetweenDates.solution(startDate, endDate);
    }
}
