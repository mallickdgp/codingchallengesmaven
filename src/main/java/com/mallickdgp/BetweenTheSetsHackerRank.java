package com.mallickdgp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BetweenTheSetsHackerRank {

    public static int solution(List<Integer> a, List<Integer> b){
        Collections.sort(a);
        Collections.sort(b);
        int aCounter;
        int bCounter;
        int lowestNumMultiple;
        int retVal = 0;
        List<Integer> numbersForConsideration = new ArrayList<>();
        for(int i=1; i<=b.get(0); i++){
            aCounter = 1;

            lowestNumMultiple = a.get(0)*i;
            if(lowestNumMultiple > b.get(0))
                break;
            boolean isCommonMultiple = true;
            while(aCounter < a.size()){

                if(lowestNumMultiple % a.get(aCounter) != 0) {
                    isCommonMultiple = false;
                    break;
                }

                aCounter++;
            }
            if(isCommonMultiple)
                numbersForConsideration.add(lowestNumMultiple);


        }
        for(Integer n: numbersForConsideration) {
            bCounter = 0;
            boolean isFactor = true;
            while (bCounter < b.size()) {
                if (b.get(bCounter) % n != 0) {
                    isFactor = false;
                    break;
                }
                bCounter++;
            }
            if (isFactor)
                retVal++;
        }
        return retVal;
    }
}
