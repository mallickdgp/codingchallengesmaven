package com.mallickdgp;

public class PractiseTestRakuten {

    public int solution(int N, int[] A){
        int foundNumber = A[0];
        int index = 0;
        for(int i=0; i<N; i++){
            if(A[i] <= foundNumber) {
                index = i;
                foundNumber = A[i];
            }
        }

        return index;
    }
}
