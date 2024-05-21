package org.example.ch1;

import org.junit.Test;

import static org.junit.Assert.*;
public class ch1Junit {

    @Test
    public void testExample1() {
        Example1 example1 = new Example1();
        int result = example1.divide(5, 2);
        assertEquals(2, result);
    }
}
