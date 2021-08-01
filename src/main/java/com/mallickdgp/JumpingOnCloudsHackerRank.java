package com.mallickdgp;

import java.util.List;

public class JumpingOnCloudsHackerRank {

    public static int solution(List<Integer> c){
        int currentPosition = 0;

        int numberOFJumps = 0;

        while(currentPosition < c.size()-1){
            if(currentPosition + 2 < c.size() && c.get(currentPosition + 2) == 0){
                currentPosition = currentPosition + 2;
            }else{
                currentPosition = currentPosition + 1;

            }
            numberOFJumps++;
        }

        return numberOFJumps;
    }
}
