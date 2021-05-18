package com.mallickdgp;

import java.util.List;


/*Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four
        of the five integers. Then print the respective minimum and maximum values as a single line of two
        space-separated long integers.*/
public class MinMaxSumOfArrayHackerRank {

    public static void solution(List<Integer> arr){
        Long minSum = (long) 0;
        Long maxSum = (long) 0;
        Long tempSum = (long) 0;
        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<arr.size(); j++){

                if(j != i)
                    tempSum = tempSum + arr.get(j);
            }
           // System.out.println("Local Sum: "+tempSum);
            if(minSum == 0 || tempSum < minSum)
                minSum = tempSum;
            if(maxSum == 0 || tempSum > maxSum)
                maxSum = tempSum;

            tempSum = (long) 0;
        }

        System.out.print(minSum+" ");
        System.out.print(maxSum);
    }
}
