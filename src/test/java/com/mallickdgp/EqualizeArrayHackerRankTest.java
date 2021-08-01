package com.mallickdgp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class EqualizeArrayHackerRankTest {

    @Test
    public void testUC01TC03(){
        int minDeletions = EqualizeArrayHackerRank.solution(Arrays.asList(3,3,2,1,3));

        assertEquals(2, minDeletions);
    }

    @Test
    public void testUC01TC02(){
        int minDeletions = EqualizeArrayHackerRank.solution(Arrays.asList(1,2,2,3));

        assertEquals(2, minDeletions);
    }

    @Test
    public void testUC01TC01(){
        int minDeletions = EqualizeArrayHackerRank.solution(Arrays.asList(1,2,3,4,5,6,7,8,9));

        assertEquals(8, minDeletions);
    }
}
