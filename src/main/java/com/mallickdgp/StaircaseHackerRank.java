package com.mallickdgp;

import java.util.Arrays;

public class StaircaseHackerRank {

    /*
    * Staircase detail

        This is a staircase of size n = 4:
        #
       ##
      ###
     ####
    * */

    public static void staircase(int n){
        for(int i=0; i<n; i++){
            for(int k=0; k<n-1-i; k++){
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
