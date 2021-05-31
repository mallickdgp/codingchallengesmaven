package com.mallickdgp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NonDivisibleSubSetHackerRank {

    /*Given a set of distinct integers, print the size of a maximal subset of S where the sum of any 2 numbers in
      S' is not evenly divisible by k.*/


    /*SOLUTION ALGO:
    * 2 numbers in the array can be represented as
    *   n1 = kx1 + y1
    *   n2 = kx2 + y2
    *  Then,
    *   n1 + n2 = k(x1+x2) + y1 + y2
    * sum divisible by k only if (y1 + y2) = k or 0
    *
    * above set of equations becomes
    * n1 - y1 = kx1
    * n2 - k- y1 = kx2;
    *
    * Hence all set of remainders will be either y1 or k-y1
    *
    * Counting the frequencies of all these numbers and finding the max will be the max size of subset.
    *
    * Except y1 = 0 and y1 = k/2
    *
    * having 2 numbers of either of these ramainders will result in subset couplet being divisible by zero.
    * Hence at max only one of these will be added to the size of the array
    * */
    public static int solution(int k, List<Integer> s){

        int result = 0;

        int[] remainders = new int[k];
        Arrays.fill(remainders, 0);

        for(int i=0; i<s.size(); i++){
            remainders[s.get(i) % k]++;
        }

        if(k % 2 == 0)
            remainders[k/2] = Math.min(remainders[k/2], 1);

        result = Math.min(remainders[0], 1);

       for(int j=1; j<=k/2; j++){
           result += Math.max(remainders[j], remainders[k-j]);
       }

       return result;

    }
}
