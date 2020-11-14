package com.mallickdgp;


public class PalindromeHackerRank {

    public void solution(String A){
        if(A == null || A.trim().equals(""))
            System.out.println("No");
        else {
            char[] charsInString = A.toLowerCase().toCharArray();
            int strLength = A.length();
            boolean palinFlag = true;
            for(int i=0; i<strLength/2; i++){
                if(charsInString[i] == charsInString[strLength-1-i])
                    continue;
                else{
                   palinFlag = false;
                    break;
                }

            }
            System.out.println(palinFlag ? "Yes" : "No");
        }

    }
}
