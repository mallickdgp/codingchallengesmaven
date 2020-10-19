package com.mallickdgp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciFrogJumpTest {

    @Test
    public void testWithNonEmptyArray(){
        int[] A = {0,0,0,1,1,0,1,0,0,0,0,0};

        int jumps = new FibonacciFrogJump().findNumberOfJumps(A);

        assertEquals(3, jumps);
    }

    @Test
    public void testWithNonEmptyArrayAllOnes(){
        int[] A = {1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        int jumps = new FibonacciFrogJump().findNumberOfJumps(A);

        assertEquals(2, jumps);
    }
}
