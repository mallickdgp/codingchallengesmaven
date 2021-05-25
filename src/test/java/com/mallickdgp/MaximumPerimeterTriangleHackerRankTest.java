package com.mallickdgp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class MaximumPerimeterTriangleHackerRankTest {

    @Test
    public void test_perimeterMAxwith6Elements(){
        List<Integer> triangle = MaximumPerimeterTriangleHackerRank.solution(Arrays.asList(1,2,3,4,5,10));

        assertEquals(3, (int) triangle.get(0));
        assertEquals(5, (int) triangle.get(2));

    }

    @Test
    public void test_perimeterMAxwith6Elements_2(){
        List<Integer> triangle = MaximumPerimeterTriangleHackerRank.solution(Arrays.asList(1,1,1,2,3,5));

        assertEquals(1, (int) triangle.get(0));
        assertEquals(1, (int) triangle.get(2));

    }

    @Test
    public void test_perimeterMAxwith5Elements(){
        List<Integer> triangle = MaximumPerimeterTriangleHackerRank.solution(Arrays.asList(1,1,1,3,3));

        assertEquals(1, (int) triangle.get(0));
        assertEquals(3, (int) triangle.get(2));

    }

    @Test
    public void test_perimeterMAxwith3Elements(){
        List<Integer> triangle = MaximumPerimeterTriangleHackerRank.solution(Arrays.asList(1,2,3));

        assertEquals(-1, (int) triangle.get(0));
      //  assertEquals(3, (int) triangle.get(2));

    }
}
