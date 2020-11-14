package com.mallickdgp;

import java.util.Map;
import java.util.stream.Collectors;

public class Anagrams {

    public boolean isAnagram(String A, String B){
        if(A.length() != B.length())
                return false;

        //boolean isAnagram = true;
        Map<Character, Integer> Achars = A.chars().boxed().collect(Collectors.toMap(
                k -> Character.valueOf((char) k.intValue()),
                v -> 1,
                Integer::sum
        ));
        Map<Character, Integer> Bchars = B.chars().boxed().collect(Collectors.toMap(
                k -> Character.valueOf((char) k.intValue()),
                v -> 1,
                Integer::sum
        ));

        for(Map.Entry<Character, Integer> entry : Achars.entrySet()){
            if(!Bchars.containsKey(entry.getKey()))
                return false;
            if(entry.getValue() != Bchars.get(entry.getKey()))
                return false;
        }

        return true;
    }

    public boolean isAnagramWithArrays(String a, String b){
        if((a == null || a.trim().equals("")) || (b == null || b.trim().equals("")))
            return false;
        if(a.length() != b.length())
            return false;

        if(a.equalsIgnoreCase(b))
            return true;

        char[] Achars = a.toLowerCase().toCharArray();
        char[] Bchars = b.toLowerCase().toCharArray();

        int[] Acount = new int[125];
        int[] Bcount = new int[125];


        for(int i=0; i< a.length(); i++){
            Acount[(int) Achars[i]]++;
            Bcount[(int) Bchars[i]]++;
        }

        for(int j=97; j<123; j++){
            if(Acount[j] != Bcount[j])
                return false;
        }

        return true;
    }
}
