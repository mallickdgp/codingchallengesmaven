package com.mallickdgp;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class PlusMinusHackerRank {

    /*Given an array of integers, calculate the ratios of its elements that are
    positive, negative, and zero. Print the decimal value of each fraction on a new line
    with 6 places after the decimal.*/

    public static void plusMinus(List<Integer> arr){
        if(arr.size() == 0)
            return;

        int posCount = 0;
        int negCount = 0;
        int zeroCount = 0;

        for(Integer n: arr){
            if(n>0)
                posCount++;
            if(n<0)
                negCount++;
            if(n == 0)
                zeroCount++;
        }

        DecimalFormat df = new DecimalFormat("#.000000");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format((double) posCount/arr.size()));
        System.out.println(df.format((double) negCount/arr.size()));
        System.out.println(df.format((double) zeroCount/arr.size()));


    }
}
