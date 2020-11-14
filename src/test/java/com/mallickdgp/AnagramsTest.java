package com.mallickdgp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramsTest {

    @Test
    public void testWithAnagram(){
        boolean response = new Anagrams().isAnagram("anagram", "margana");
        boolean response2 = new Anagrams().isAnagramWithArrays("anagram", "margana");

        assertTrue(response);
        assertTrue(response2);
    }

    @Test
    public void testWithNotAnagram(){
        boolean response = new Anagrams().isAnagram("anagramm", "marganaa");
        boolean response2 = new Anagrams().isAnagramWithArrays("anagramm", "marganaa");

        assertFalse(response);
        assertFalse(response2);
    }
}
