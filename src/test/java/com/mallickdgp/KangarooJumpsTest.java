package com.mallickdgp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KangarooJumpsTest {

    @Test
    public void testWithSameStarting(){
        int x1=0;
        int x2=0;

        int v1=1;
        int v2=2;

        String ans = KangarooJumps.solution(x1, v1, x2, v2);

        assertEquals("NO", ans);
    }

    @Test
    public void testWithX1grtrthnX2andV1lessthnV2(){
        int x1=5;
        int x2=3;

        int v1=2;
        int v2=3;

        String ans = KangarooJumps.solution(x1, v1, x2, v2);

        assertEquals("YES", ans);
    }

    @Test
    public void TC01UC03(){
        int x1=0;
        int x2=5;

        int v1=2;
        int v2=3;

        String ans = KangarooJumps.solution(x1, v1, x2, v2);

        assertEquals("NO", ans);
    }
}
