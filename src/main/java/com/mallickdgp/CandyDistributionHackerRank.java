    package com.mallickdgp;

    import java.util.*;

    /*Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  All the children
    sit in a line and each of them has a rating score according to his or her performance in the class.  Alice wants to
    give at least 1 candy to each child. If two children sit next to each other, then the
    one with the higher rating must get more candies. Alice wants to minimize the total number of candies she must buy.*/
    public class CandyDistributionHackerRank {

        public static long solution(int n, List<Integer> arr){
            int i=1;

            long totalCandy = 1;
            int givenCandie = 1;
            List<Integer> candieToStudent = new ArrayList<>(Collections.nCopies(n, 1));
            //Going forward
           while(i<=n-1){
               if(arr.get(i) > arr.get(i-1)) {
                   givenCandie++;
                   candieToStudent.set(i, givenCandie);
               }else
                   givenCandie = 1;

               i++;

           }
          //coming backwords
            givenCandie = 1;
            int j = n-2;
            while(j>=0){
                if(arr.get(j) > arr.get(j+1)){
                    givenCandie++;
                    if(givenCandie > candieToStudent.get(j))
                        candieToStudent.set(j, givenCandie);
                }else{
                    givenCandie = 1;
                }

                j--;
            }
            totalCandy = candieToStudent.stream().mapToInt(num -> num).sum();

           return totalCandy;
        }
    }
