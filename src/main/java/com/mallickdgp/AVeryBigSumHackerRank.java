package com.mallickdgp;

import java.util.List;

public class AVeryBigSumHackerRank {


    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        long retVal = 0;

        for(Long num: ar){
            retVal = retVal+num;
        }

        return retVal;
    }
}
