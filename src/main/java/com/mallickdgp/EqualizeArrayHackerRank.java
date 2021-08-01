package com.mallickdgp;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EqualizeArrayHackerRank {

    /*Given an array of
    integers, determine the minimum number of elements to delete to leave only elements of equal value.*/

    public static int solution(List<Integer> arr){
       int[] frequency = new int[101];

        Arrays.fill(frequency, 0);

        for(int i=0; i<arr.size(); i++){
            frequency[arr.get(i)]++;
        }

        Arrays.sort(frequency);



        int minDeletions = 0;

        for(int j=99; j>0; j--){
            if(frequency[j] == 0)
                break;

            minDeletions += frequency[j];
        }

        return minDeletions;
    }
}
