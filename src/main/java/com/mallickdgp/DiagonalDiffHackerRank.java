package com.mallickdgp;

import java.util.List;

public class DiagonalDiffHackerRank {

    public static int diagonalDiff(List<List<Integer>> arr){
        int diag1 = 0;
        int diag2 = 0;
        Integer[][] arr2d = arr.stream().map(x -> x.toArray(new Integer[x.size()])).toArray(Integer[][]::new);
        int i=0;
        int j= arr2d.length - 1;
        while(i< arr2d.length && j>=0){
            diag1 = diag1 + arr2d[i][i];
            diag2 = diag2 + arr2d[i][j];
            i++;
            j--;
        }

        return Math.abs(diag1 - diag2);
    }
}
