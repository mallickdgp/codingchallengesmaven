package com.mallickdgp;

import java.util.HashMap;

public class FibonacciFrogJump {
    private static HashMap<Integer, Integer> memoiMap = new HashMap<>();
    static {
        memoiMap.put(0, 0);
        memoiMap.put(1, 1);
    }
    public int findNumberOfJumps(int[] A){
        int N = A.length;
        HashMap<Integer, Integer> fibo = new HashMap<>();
        int fibItr = 0;
        int fibVal = 0;
        while(fibVal < N){
            fibVal = generateFibonacci(fibItr);
            fibo.put(fibItr, fibVal);
            fibItr++;
        }

        int jumpCount = 0;
        int D = 0;
        for(int i=0; i<N; i++){
            D++;
            if(A[i] == 1){
               if(fibo.containsValue(D)){
                   jumpCount++;
                   D=0;
               }
            }
        }

        return jumpCount+1;
    }

    private int generateFibonacci(int x){
       return memoiMap.computeIfAbsent(x,n -> generateFibonacci(n-1) + generateFibonacci( n-2));
    }
}
