package com.mallickdgp;

import java.util.LinkedList;
import java.util.List;

/*Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  All the children
sit in a line and each of them has a rating score according to his or her performance in the class.  Alice wants to
give at least 1 candy to each child. If two children sit next to each other, then the
one with the higher rating must get more candies. Alice wants to minimize the total number of candies she must buy.*/
public class CandyDistributionHackerRank {

    public static int solution(int n, List<Integer> arr){
        int i=1;
        int totalCandy = 1;
        int givenCandie = 1;
        System.out.print(givenCandie+" ");
       while(i<n-1){
           if(arr.get(i) > arr.get(i-1))
               givenCandie++;

           else{
               if(givenCandie>2)
                   givenCandie = Math.max(2, 4);
               givenCandie = Math.max(1, givenCandie-1);
           }
           System.out.print(givenCandie+" ");
           totalCandy = givenCandie+totalCandy;
           i++;

       }
       if(arr.get(n-1) <= arr.get(n-2))
           givenCandie = 1;
       else
           givenCandie++;
        System.out.print(givenCandie);

       totalCandy = totalCandy + givenCandie;

       return totalCandy;
    }
}
