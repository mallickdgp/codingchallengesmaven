package com.mallickdgp;

import java.util.Arrays;

public class CloseStringsLeetcode {
    /*
    Two strings are considered close if you can attain one from the other using the following operations:

    Operation 1: Swap any two existing characters.
    For example, abcde -> aecdb
    Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
    For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
    You can use the operations on either string as many times as necessary.

    Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
     */
    public static boolean solution(String word1, String word2) {
        if(word1 == null || ("").equals(word1) || word2 == null || ("").equals(word2))
            return false;

        if(word1.length() != word2.length())
            return false;

        return determineIfStringsAreClose(word1, word2);

    }

    public static boolean determineIfStringsAreClose(String word1, String word2){
        int[] w1 = new int[26];
        int[] w2 = new int[26];

        for(char c: word1.toCharArray()){
            w1[c - 'a']++;
        }

        for(char c: word2.toCharArray()){
            w2[c - 'a']++;
        }

        for(int i=0; i<26; i++){
            if((w1[i] == 0 && w2[i] != 0) || (w2[i] == 0 && w1[i] != 0))
                return false;
        }

        Arrays.sort(w1);
        Arrays.sort(w2);
        return Arrays.equals(w1, w2);
    }
}
