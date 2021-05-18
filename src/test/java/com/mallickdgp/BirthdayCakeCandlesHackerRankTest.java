package com.mallickdgp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BirthdayCakeCandlesHackerRankTest {

    @Test
    public void test_Candleswith4ItemsOneRepeated(){
        List<Integer> candles = Arrays.asList(4,4,1,3);

        int count = BirthdayCakeCandlesHackerRank.solution(candles);

        assertEquals(2, count);
    }

    @Test
    public void test_Candleswith6ItemsNoneRepeated(){
        List<Integer> candles = Arrays.asList(6,1,5,2,4,3);

        int count = BirthdayCakeCandlesHackerRank.solution(candles);

        assertEquals(1, count);
    }
}
