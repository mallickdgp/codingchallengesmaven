package com.mallickdgp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Stream;

public class ValidateYearlyDateAndOccurances {
    public static void solution(String recurrenceDetails, String fromDate, String toDate){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> recurrendetailsMap = mapper.readValue(recurrenceDetails, Map.class);
            validateForYearlyAlt(recurrendetailsMap, fromDate, toDate);
        }catch (Exception iex){
            System.out.println(iex.getLocalizedMessage());
        }
    }

    public static void validateForYearly(Map<String, Object> recurrenceDetails, String fromDate, String toDate) throws ParseException{
        try {
            //for validating against the last date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate = sdf.parse(fromDate);
            Date endDate = sdf.parse(toDate);
            List<Map<String, Object>> listOfMonthlyDetails = (List<Map<String, Object>>) recurrenceDetails.get("det");
            if (null == listOfMonthlyDetails || listOfMonthlyDetails.isEmpty()) {
               // throw ExceptionUtil.getApplicationException(ErrorCode.EMPTY_FIELD, new String[]{Constants.YEARLY_DETAILS}, Constants.EMPTY_FIELDS, HttpStatus.BAD_REQUEST);
            }
            Map<String, Integer> loopingDetails = calculateActiveNumberOfYearAndMonth(startDate, endDate);
            //loop for years
            Integer yearCount = loopingDetails.get("loopForNumberYears");

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            Integer yearValue = calendar.get(Calendar.YEAR);
            Map<String, Object> listOfMonthsDetails = listOfMonthlyDetails.get(0);
            Integer monthLoopingLimit = 0;
            boolean dateCheckRequired = false;
            Integer lastDayForTheRequest = 0;
            do {
                if (yearCount == 0) {
                    List<Map<String, Object>> validMonthsForLastYear = new ArrayList<>();
                    // As YearMonth runs from 1-12 for months.
                    monthLoopingLimit = loopingDetails.get("loopForNumberOfMonths") + 1;
                    dateCheckRequired = true;
                    lastDayForTheRequest = loopingDetails.get("lastDayOfLoop");
                    extractMonthsAndDays(validMonthsForLastYear, listOfMonthlyDetails, monthLoopingLimit);
                    listOfMonthlyDetails = validMonthsForLastYear;
                }
                List<String> listOfDays = (List<String>) listOfMonthsDetails.get("day");
                if (null == listOfDays || listOfDays.isEmpty()) {
                   // throw ExceptionUtil.getApplicationException(ErrorCode.EMPTY_FIELD, new String[]{Constants.DAYS_OF_MONTH}, Constants.EMPTY_FIELDS, HttpStatus.BAD_REQUEST);
                }
                YearMonth yearMonthObject = YearMonth.of(yearValue,
                        Integer.parseInt(String.valueOf(listOfMonthsDetails.get("month"))));
                for (int monthCount = 0; monthCount <= listOfMonthlyDetails.size(); monthCount++) {

                    Integer finalLastDayForTheRequest = lastDayForTheRequest;
                    boolean finalDateCheckRequired = dateCheckRequired;
                    Integer finalMonthLoopingLimit = monthLoopingLimit;
                    int lengthOfMonth = yearMonthObject.lengthOfMonth();
                    validateForDate(listOfDays, finalLastDayForTheRequest, finalDateCheckRequired, finalMonthLoopingLimit, lengthOfMonth,
                            yearMonthObject, listOfMonthsDetails);
                }
                yearValue++;
                yearCount--;
            } while (yearCount >= 0);
        } catch (ParseException ae) {
            throw ae;
        } catch (RuntimeException ae) {
           // LOGGER.info("Exception happened at validateForYearly", ae);
          //  throw ExceptionUtil.getApplicationException(ErrorCode.VERIFY_DATE_OR_MONTH_YEAR, "verify.date.month.year", HttpStatus.BAD_REQUEST);
        }
    }


    private static void extractMonthsAndDays(List<Map<String, Object>> validMonthsForLastYear, List<Map<String, Object>> listOfMonthlyDetails, Integer monthLoopingLimit) {

        for (Map<String, Object> validMonths : listOfMonthlyDetails) {
            if ((Integer.parseInt(String.valueOf(validMonths.get("month")))) < 0
                    || (Integer.parseInt(String.valueOf(validMonths.get("month")))) > 12) {
               // throw ExceptionUtil.getApplicationException(ErrorCode.INVALID_MONTH_VALUE, new String[]{String.valueOf                 (validMonths.get("month"))}, "invalid.month.value", HttpStatus.BAD_REQUEST);
            } else if ((Integer.parseInt(String.valueOf(validMonths.get("month")))) <= monthLoopingLimit) {
                validMonthsForLastYear.add(validMonths);
            }
        }
    }


    public static Map<String, Integer> calculateActiveNumberOfYearAndMonth(Date startDate, Date endDate) {
   
      //  Date startDate = datesUtils.transformToValidDate(custRecurringEventsDto.getStartDate(), Constants.START_DATE);
       // Date endDate = datesUtils.transformToValidDate(custRecurringEventsDto.getEndDate(), Constants.END_DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        //start date
        Integer startYear = calendar.get(Calendar.YEAR);
        calendar.setTime(endDate);
        //end date
        Integer endYear = calendar.get(Calendar.YEAR);
        Integer differenceOfYears = endYear - startYear;
        Map<String, Integer> monthAndDateCount = new HashMap();
        monthAndDateCount.put("loopForNumberYears", differenceOfYears);
        //fetch months up to which the validation should happen.
        monthAndDateCount.put("loopForNumberOfMonths", calendar.get(Calendar.MONTH));
        monthAndDateCount.put("lastDayOfLoop", calendar.get(Calendar.DATE));
        return monthAndDateCount;
    }


    private static void validateForDate(List<String> listOfDays, Integer finalLastDayForTheRequest,
                                        boolean finalDateCheckRequired,
                                        Integer finalMonthLoopingLimit, int lengthOfMonth,
                                        YearMonth yearMonthObject,
                                        Map<String, Object> listOfMonthsDetails) {
        listOfDays.stream().forEach(value -> {
            if (finalDateCheckRequired && Integer.parseInt(String.valueOf(listOfMonthsDetails.get("month")))
                    == finalMonthLoopingLimit && Integer.parseInt(value) > finalLastDayForTheRequest) {

               } else if (Integer.parseInt(value) > lengthOfMonth) {

               }
        });
    }


    public static void validateForYearlyAlt(Map<String, Object> recurrenceDetails, String fromDate, String toDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate = sdf.parse(fromDate);
            Date endDate = sdf.parse(toDate);
            Calendar beginCalender = GregorianCalendar.getInstance();
            Calendar finishCalender = GregorianCalendar.getInstance();
            beginCalender.setTime(startDate);
            finishCalender.setTime(endDate);
            final TreeMap<Integer, Integer> monthsInDateRange = new TreeMap<Integer, Integer>(calculateMonthsInDateRange(beginCalender, finishCalender));
           // final HashMap<Integer, Integer> monthsInDateRange = ;

            final Integer lastDayOfRecurrence = calculateLastDayofIterationLimit(finishCalender);
            final Integer firstDayOfRecurrence = calculateFirstDayofIterationLimit(beginCalender);
            final Integer lastMonthofIteration = calculateLastMonthofIterationLimit(finishCalender);
            final Integer firstMonthofIteration = calculateFirstMonthofIterationLimit(beginCalender);
            final List listOfDays = new ArrayList<String>();
            if(recurrenceDetails.containsKey("det")){
                getMonthsAndDaysfromRecurrenceDetails(recurrenceDetails).forEach(md ->{
                    if(!monthsInDateRange.containsKey(Integer.parseInt((String) md.get("month")) - 1))
                        throw new IllegalStateException("Month in recurrence not present in date range!");
                    boolean isLastMonthOfIteration = false;
                    if(lastMonthofIteration ==  Integer.parseInt((String) md.get("month")) - 1)
                        isLastMonthOfIteration = true;

                    boolean isFirstMonthOfIteration = false;
                    if(firstMonthofIteration == Integer.parseInt((String) md.get("month")) - 1)
                        isFirstMonthOfIteration = true;

                    listOfDays.addAll((List<String>) md.get("day"));
                    for(Object day : listOfDays){
                        Integer dayInt = Integer.parseInt((String) day);
                        if( dayInt > 0 && dayInt > monthsInDateRange.get
                                (Integer.parseInt((String) md.get("month")) - 1)){
                            throw new IllegalStateException("Day in recurrence is illegal!");
                        }
                        if(isLastMonthOfIteration && Integer.parseInt((String) day) > lastDayOfRecurrence)
                            throw new IllegalArgumentException("Last day of recurrance is greater than end date!");

                        if(isFirstMonthOfIteration && Integer.parseInt((String) day) < firstDayOfRecurrence)
                            throw new IllegalArgumentException("First day of recurrance is less than start date!");
                    }
                    listOfDays.clear();


                });
            }else{
                throw new IllegalArgumentException("Recurrence Details missing in data!");
            }


        }catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public static HashMap<Integer, Integer> calculateMonthsInDateRange(Calendar beginCalender, Calendar finishCalender){



        HashMap<Integer, Integer> noOfMonths = new HashMap<>();

        while(beginCalender.before(finishCalender)){

            noOfMonths.put(beginCalender.get(Calendar.MONTH), getMaxDaysforMonth(beginCalender));


            beginCalender.add(Calendar.MONTH, 1);
        }
        return noOfMonths;
    }

    public static List<Map<String, Object>> getMonthsAndDaysfromRecurrenceDetails(Map<String, Object> recurrenceDetails){
        List<Map<String, Object>> listOfMonthlyDetails = (List<Map<String, Object>>) recurrenceDetails.get("det");



        return listOfMonthlyDetails;
    }

    public static Integer getMaxDaysforMonth(Calendar calender){
        Integer yearValue = calender.get(Calendar.YEAR);

        YearMonth yearMonth = YearMonth.of(yearValue, calender.get(Calendar.MONTH) + 1);

        return yearMonth.lengthOfMonth();
    }

    public static Integer calculateLastDayofIterationLimit(Calendar finishCalender){
        return finishCalender.get(Calendar.DAY_OF_MONTH);
    }

    public static Integer calculateFirstDayofIterationLimit(Calendar beginCalendar){
        return beginCalendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Integer calculateLastMonthofIterationLimit(Calendar finishCalender){
        return finishCalender.get(Calendar.MONTH);
    }
    public static Integer calculateFirstMonthofIterationLimit(Calendar beginCalendar){
        return beginCalendar.get(Calendar.MONTH);
    }

}
