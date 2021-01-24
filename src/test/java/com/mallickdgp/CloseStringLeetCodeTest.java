package com.mallickdgp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CloseStringLeetCodeTest {

    @Test
    public void testWithPossibleStrings_ShouldPass(){
        String word1 = "cabbba";
        String word2 = "abbccc";

        assertTrue(CloseStringsLeetcode.solution(word1, word2));
    }

    @Test
    public void testWithNotPossibleStrings_ShouldFail(){
        String word1 = "cabbba";
        String word2 = "aabbss";

        assertFalse(CloseStringsLeetcode.solution(word1, word2));
    }

    @Test
    public void testWithStringsofDifferentLength_ShouldFail(){
        String word1 = "a";
        String word2 = "aa";

        assertFalse(CloseStringsLeetcode.solution(word1, word2));
    }
}
