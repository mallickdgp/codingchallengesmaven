package com.mallickdgp;

import org.junit.Test;

public class RemoveDuplicateWordsTest {

    @Test
    public void testWith3Sentences(){
        RemoveDuplicateWords.solution("Goodbye bye bye world world world");
        RemoveDuplicateWords.solution("Sam went went to to to his business");
        RemoveDuplicateWords.solution("Reya is is the the best player in eye eye game");
        RemoveDuplicateWords.solution("in inthe");
        RemoveDuplicateWords.solution("Hello hello Ab aB");
    }
}
