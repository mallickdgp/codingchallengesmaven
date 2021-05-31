package com.mallickdgp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NonDivisibleSubSetHackerRankTest {

    @Test
    public void test_UC01TC01(){
        int k = 7;
        List<Integer> s = Arrays.asList(278,576,496,727,410,124,338,149,209,702,282,718,771,575,436);

        assertEquals(11, NonDivisibleSubSetHackerRank.solution(k, s));
    }
}
