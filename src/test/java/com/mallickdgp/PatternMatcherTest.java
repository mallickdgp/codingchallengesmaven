package com.mallickdgp;

import org.junit.Test;

import java.util.regex.Pattern;

public class PatternMatcherTest {

    @Test
    public void testWith3Patterns(){
        PatternMatcher.solution("([A-Z])(.+)");
        PatternMatcher.solution("[AZ[a-z](a-z)");
        PatternMatcher.solution("batcatpat(nat");
    }
}
