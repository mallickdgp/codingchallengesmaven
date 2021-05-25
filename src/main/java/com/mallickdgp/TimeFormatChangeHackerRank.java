package com.mallickdgp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatChangeHackerRank {


    /*Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

    Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
            - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.*/
    public static String solution(String s){
        try {
            Date date = new SimpleDateFormat("hh:mm:ssaa").parse(s);


            String newFormat = new SimpleDateFormat("HH:mm:ss").format(date);

            return newFormat;
        }catch (ParseException pex){
            System.out.println("Could not parse given date!");
            return s;
        }
    }
}
