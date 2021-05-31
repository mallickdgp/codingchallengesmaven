package com.mallickdgp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class FactorialOfBigNumberHackerRank {

    private static Map<Integer, BigInteger> memoiMap = new HashMap<>();
    private static int M = (int) Math.pow(10,9)+7;

    public static void solution(int N){
        System.out.println(findFactorial(N));
    }

    public static BigInteger findFactorial(int N){
        if(N == 0)
            return BigInteger.ONE;
       return BigInteger.valueOf(N).multiply(findFactorial(N-1));


    }
}
