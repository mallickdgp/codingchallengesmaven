package com.mallickdgp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PlusMinusHackerRackTest {

    @Test
    public void test_plusMinus(){
        List<Integer> arr = Arrays.asList(1,1,0,-1,-1);

        PlusMinusHackerRank.plusMinus(arr);
    }
}
