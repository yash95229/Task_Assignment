package com.task.trackMessageQueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
   PURPOSE OF THIS TEST TO RETURN THE CORRECT FRUIT NAME
 */
public class MessageTest {

	// THIS CHECK IF IT RETURNS THE CORRECT FRUIT NAME
    @Test
   public void testGetFruitName() {
        Message message = new Message("Apple");
        	assertEquals("Apple", message.getFruitName(), "Fruit name should be 'Apple'");
    }

    @Test
    public void testToString() {
        Message message = new Message("Banana");
        assertEquals(" Current Fruit :> 'Banana'", message.toString(), "should return ' Current Fruit :> 'Banana''");
    }
}
