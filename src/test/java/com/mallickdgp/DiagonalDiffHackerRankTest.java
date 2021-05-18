package com.mallickdgp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DiagonalDiffHackerRankTest {

    @Test
    public void testDiagonalDiff3X3(){
        List<List<Integer>> mainArr = new ArrayList<>();
        List<Integer> internal1 = Arrays.asList(11,2,4);
        mainArr.add(internal1);
        List<Integer> internal2 = Arrays.asList(4,5,6);
        mainArr.add(internal2);
        List<Integer> internal3 = Arrays.asList(10,8,-12);
        mainArr.add(internal3);

        assertEquals(15, DiagonalDiffHackerRank.diagonalDiff(mainArr));

    }
}
