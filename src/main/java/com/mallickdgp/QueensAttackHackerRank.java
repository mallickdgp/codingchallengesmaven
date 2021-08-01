package com.mallickdgp;

import java.util.List;

public class QueensAttackHackerRank {
        /*You will be given a square chess board with one queen and a number of obstacles placed on it.
        Determine how many squares the queen can attack.*/
    public static int solution(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles){
        int numberOfMoves =0;
        numberOfMoves += findNumberOfMoves(n, k, r_q-1, c_q, -1, 0, obstacles);

        numberOfMoves += findNumberOfMoves(n, k, r_q-1, c_q-1, -1,-1, obstacles);

        numberOfMoves += findNumberOfMoves(n, k, r_q, c_q-1, 0, -1,  obstacles);

        numberOfMoves += findNumberOfMoves(n, k, r_q+1, c_q-1, 1, -1, obstacles);

        numberOfMoves += findNumberOfMoves(n, k, r_q+1, c_q, 1, 0, obstacles);

        numberOfMoves += findNumberOfMoves(n, k, r_q+1, c_q+1, 1,1, obstacles);

        numberOfMoves += findNumberOfMoves(n, k, r_q, c_q+1, 0, 1, obstacles);

        numberOfMoves += findNumberOfMoves(n, k, r_q-1, c_q+1, -1, 1, obstacles);

        return numberOfMoves;
    }

    public static int findNumberOfMoves(int n, int k, int r_q, int c_q, int tr_q, int tc_q,
                                        List<List<Integer>> obstacles) {
        int numberOfMoves = 0;
        while (r_q > 0 && r_q <= n && c_q>0 && c_q <= n) {
            boolean blockFound = false;


           if(ifBlockedMove(r_q, c_q, k, obstacles))
            break;

            r_q+= tr_q;
            c_q+= tc_q;
            numberOfMoves++;
        }



        return numberOfMoves;
    }

    public static boolean ifBlockedMove(int r_q, int c_q, int k, List<List<Integer>> obstacles){
        boolean  blockFound = false;
        while(k >= 1){
            if (obstacles.get(k-1).get(0) == r_q && obstacles.get(k-1).get(1) == c_q) {
                blockFound = true;
                break;
            }
            k--;
        }

        return blockFound;
    }
}
