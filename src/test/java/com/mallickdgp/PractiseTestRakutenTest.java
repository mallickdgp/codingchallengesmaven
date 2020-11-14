package com.mallickdgp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PractiseTestRakutenTest {

    @Test
    public void testWith5Elements(){
        int[] A = {0,2,3,4,5};
        int N = 5;

        int index = new PractiseTestRakuten().solution(N, A);

        assertEquals(0, index);
    }

    @Test
    public void testWithRepeatElements(){
        int[] A = {99, 65, 23, 1, 1, 78, 2, 56, 9};
        int N = 9;

        int index = new PractiseTestRakuten().solution(N, A);

        assertEquals(4, index);
    }

    @Test
    public void testWithAllRepeatElements(){
        int[] A = {1,1,1,1,1,1};
        int N = 6;

        int index = new PractiseTestRakuten().solution(N, A);

        assertEquals(5, index);
    }
}
