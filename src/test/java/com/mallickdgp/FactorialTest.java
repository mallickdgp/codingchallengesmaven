package com.mallickdgp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void findFactorialTest(){
        int factorial = new Factorial().findFactorial(1);

        assertEquals(1, factorial);
    }
}
