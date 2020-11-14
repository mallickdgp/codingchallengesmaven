package com.mallickdgp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class FactorialWithDP {
    HashMap<Integer, Long> memoiMap = new HashMap<>();
    static int M = (int) Math.pow(10, 9) + 7;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T>0){
            System.out.println(findFactorialWithDP(Integer.parseInt(br.readLine())));
            T--;
        }
    }
    public long findFactorialWithDP(int N){
        if(N==0)
            return 1;
        if(memoiMap.containsKey(N))
            return memoiMap.get(N);

        memoiMap.put(N, (N*findFactorialWithDP(N-1))%M);
        return memoiMap.get(N);
    }
}
