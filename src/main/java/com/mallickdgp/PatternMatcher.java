package com.mallickdgp;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternMatcher {

    public static void solution(String pattern) {
        if (pattern != null) {
            try {
                Pattern p1 = Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (PatternSyntaxException psx) {
                System.out.println("Invalid");
            }
        }else
            System.out.println("Invalid");
    }
}
