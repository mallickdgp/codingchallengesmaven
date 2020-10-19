package com.mallickdgp;

import java.util.Arrays;

public class StringSplitTravelPerk {

    public int solution(String S){
        if(S == null || S.trim().equals(""))
            return 0;
        int length = S.length();
        if(S.contains("a")){
            int count = (int) S.chars().filter(ch -> ch == 'a').count();

            if(count % 3 > 0)
                return 0;
            else{
                int AinEach = count / 3;
                int firstSubStrCombo = 0;
                int secondSubStrCombo = 0;
                int strACounter = 0;
                for(int i=0; i< length ; i++){
                    if(S.charAt(i) == 'a')
                        strACounter++;

                    if(strACounter == AinEach)
                        firstSubStrCombo++;
                    else if(strACounter == 2 * AinEach)
                        secondSubStrCombo++;
                }

                return firstSubStrCombo * secondSubStrCombo;
            }
        }else{
                return ((length-1)*(length-2))/2;
        }
    }
}
