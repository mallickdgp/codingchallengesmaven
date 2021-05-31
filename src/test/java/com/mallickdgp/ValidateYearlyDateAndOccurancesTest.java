package com.mallickdgp;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class ValidateYearlyDateAndOccurancesTest {

    @Test
    public void test_startMonthBeforeStartDate(){
        String startDate = "01/04/2021";
        String endDate = "30/12/2021";

        String recurrenceDetails = "{\n" +
                "  \"det\": [\n" +
                "    {\n" +
                "      \"month\": \"6\",\n" +
                "      \"day\": [\n" +
                "        \"10\",\n" +
                "        \"20\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        ValidateYearlyDateAndOccurances.solution(recurrenceDetails, startDate, endDate);
    }

    @Test
    public void test_CalculateMonthinDateRange(){
        try{
            Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2021");
            Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse("02/04/2022");
//            Calendar beginCalender = GregorianCalendar.getInstance();
//            Calendar finishCalender = GregorianCalendar.getInstance();
//            beginCalender.setTime(startDate);
//            finishCalender.setTime(endDate);

            HashMap<Integer, Integer> noOfMonths = ValidateYearlyDateAndOccurances
                    .calculateMonthsInDateRange(startDate, endDate);

            assertEquals(11, noOfMonths.size());
        }catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }

    @Test
    public void test_MultipleOccurances(){
        String startDate = "09/07/2021";
        String endDate = "30/05/2022";

        String recurrenceDetails = "{\n" +
                "  \"det\": [\n" +
                "    {\n" +
                "      \"month\": \"7\",\n" +
                "      \"day\": [\n" +
                "        \"10\",\n" +
                "        \"20\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"month\": \"8\",\n" +
                "      \"day\": [\n" +
                "        \"10\",\n" +
                "        \"20\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"month\": \"5\",\n" +
                "      \"day\": [\n" +
                "        \"10\",\n" +
                "        \"28\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        ValidateYearlyDateAndOccurances.solution(recurrenceDetails, startDate, endDate);
    }
}
