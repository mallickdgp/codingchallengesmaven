package com.mallickdgp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CandyDistributionHackerRankTest {

    @Test
    public void test_with3students(){
        long total = CandyDistributionHackerRank.solution(3, Arrays.asList(1,2,2));

        assertEquals(4, total);

    }

    @Test
    public void test_with10students(){
        long total = CandyDistributionHackerRank.solution(10, Arrays.asList(2,4,2,6,1,7,8,9,2,1));

        assertEquals(19, total);

    }

    @Test
    public void test_withmostlyIncreasingGrades(){
        long total = CandyDistributionHackerRank.solution(10, Arrays.asList(1,2,3,4,5,6,4,3,2,1));

        assertEquals(31, total);

    }

    @Test
    public void test_HR01TC01(){
        long total = CandyDistributionHackerRank.solution(10, Arrays.asList(2,4,2,6,1,7,8,9,2,1));

        assertEquals(19, total);

    }

    @Test
    public void test_HR01TC02(){
        long total = CandyDistributionHackerRank.solution(8, Arrays.asList(2,4,3,5,2,6,4,5));

        assertEquals(12, total);

    }
}
