package com.mallickdgp;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/*You are in charge of the cake for a child's birthday. You have decided the cake will have one candle for each year
 of their total age. They will only be able to blow out the tallest of the candles. Count how many candles are tallest.*/
public class BirthdayCakeCandlesHackerRank {

    public static int solution(List<Integer> candles){
        SortedMap<Integer, Integer> countMap = new TreeMap<Integer, Integer>();

        for(Integer candle: candles){
            if(countMap.containsKey(candle))
                countMap.put(candle, countMap.get(candle)+1);
            else
                countMap.put(candle, 1);
        }

        return (int) countMap.get(countMap.lastKey());
    }
}
