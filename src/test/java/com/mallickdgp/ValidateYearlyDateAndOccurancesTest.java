package com.mallickdgp;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
            Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse("30/09/2022");


            HashMap<Integer, Integer> noOfMonths = ValidateYearlyDateAndOccurances.calculateMonthsInDateRange(startDate, fromDate);

            assertEquals(16, noOfMonths.size());
        }catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }

    @Test
    public void test_MultipleOccurances(){
        String startDate = "01/07/2021";
        String endDate = "30/06/2022";

        String recurrenceDetails = "{\n" +
                "  \"det\": [\n" +
                "    {\n" +
                "      \"month\": \"6\",\n" +
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
                "      \"month\": \"10\",\n" +
                "      \"day\": [\n" +
                "        \"10\",\n" +
                "        \"31\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        ValidateYearlyDateAndOccurances.solution(recurrenceDetails, startDate, endDate);
    }
}
