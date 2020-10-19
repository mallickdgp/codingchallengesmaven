package com.mallickdgp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringSplitTravelPerkTest {

    @Test
    public void testWithStartingB(){
        String S = "babaa";

        assertEquals(2, new StringSplitTravelPerk().solution(S));
    }

    @Test
    public void testWithNoA(){
        String S = "bbbbb";

        assertEquals(6, new StringSplitTravelPerk().solution(S));
    }

    @Test
    public void testWithStartingA(){
        String S = "ababa";
        int answer = new StringSplitTravelPerk().solution(S);
        assertEquals(4, answer);
    }
}
