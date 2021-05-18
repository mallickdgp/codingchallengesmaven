package com.mallickdgp;

import org.junit.Test;

import java.util.Arrays;

public class MinMaxSumOfArrayHackerRankTest {

    @Test
    public void test_MinMaxSumOfArrayHackerRank(){
        MinMaxSumOfArrayHackerRank.solution(Arrays.asList(1,2,3,4,5));
    }

    @Test
    public void test_MinMaxSumOfArrayHackerRankBigNumbers(){
        MinMaxSumOfArrayHackerRank.solution(Arrays.asList(1234567890,2000000000,2000000000,2000000000,2000000000));
    }
}
