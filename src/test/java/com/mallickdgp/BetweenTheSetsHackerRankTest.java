package com.mallickdgp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BetweenTheSetsHackerRankTest {

    @Test
    public void TC01UC01(){
        List<Integer> a = Arrays.asList(2,4);
        List<Integer> b = Arrays.asList(32,16,96);

        assertEquals(3, BetweenTheSetsHackerRank.solution(a,b));
    }

    @Test
    public void TC01UC02(){
        List<Integer> a = Arrays.asList(2,6);
        List<Integer> b = Arrays.asList(24,36);

        assertEquals(2, BetweenTheSetsHackerRank.solution(a,b));
    }

    @Test
    public void TC01UC03(){
        List<Integer> a = Arrays.asList(3,4,6);
        List<Integer> b = Arrays.asList(36,48, 96);

        assertEquals(1, BetweenTheSetsHackerRank.solution(a,b));
    }

    @Test
    public void TC01UC04(){
        List<Integer> a = Arrays.asList(3,3);
        List<Integer> b = Arrays.asList(12,18,27,48);

        assertEquals(1, BetweenTheSetsHackerRank.solution(a,b));
    }


}
