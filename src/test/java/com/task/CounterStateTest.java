package com.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
  PURPOSE OF THIS TEST TO VALIDATE THAT COUNTS ARE INCREMENTED CORRECTLY FOR SUCCESS AND ERROR CASES
 */
public class CounterStateTest {

    @Test
   public void testIncrementSuccess() {
        
    CounterState counterState = new CounterState();
        counterState.incrementSuccess();
        assertEquals(1, counterState.getSuccessCount(), "Success count should be 1");
    }

    @Test
    public void testIncrementError() {
        CounterState counterState = new CounterState();
        counterState.incrementError();
        assertEquals(1, counterState.getErrorCount(), "Error count should be 1");
    }
}
