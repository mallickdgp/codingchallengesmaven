package com.mallickdgp;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FactorialWithDPTest {

    @Test
    public void testWithNumber(){
        FactorialWithDP fact = new FactorialWithDP();
        long factorial = fact.findFactorialWithDP(5);

        assertEquals(120, factorial);
    }

    @Test
    public void testWithUserInput() throws Exception{
        FactorialWithDP factClass = new FactorialWithDP();

        factClass.solution();
    }
}
