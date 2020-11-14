package com.mallickdgp;

import org.junit.Test;

public class PalindromeHackerRankTest {

    @Test
    public void testWithPalindromeString(){
        new PalindromeHackerRank().solution("madam");
    }

    @Test
    public void testWithNonPalindromeString(){
        new PalindromeHackerRank().solution("ratna");
    }


}
