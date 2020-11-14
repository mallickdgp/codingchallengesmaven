package com.mallickdgp;

import java.util.stream.Stream;

public class StringBasicHackerRank {

    public void solution(String A, String B){
        int sumLength = A.length()+B.length();
        System.out.println(sumLength);
        System.out.println(A.compareTo(B) <= 0 ? "No" : "Yes");

        char[] Achars = A.toCharArray();

        char[] Bchars = B.toCharArray();

        Achars[0] = (char) (Achars[0] - 'a' + 'A');
        Bchars[0] = (char) (Bchars[0] -'a' + 'A');

        System.out.println(new String(Achars)+" "+new String(Bchars));
    }
}
