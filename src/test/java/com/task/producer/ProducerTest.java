package com.task.producer;

import com.task.trackMessageQueue.Message;
import com.task.trackMessageQueue.MessageQueue;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/*
  PURPOSE OF THIS TEST THAT PRODUCER ADDS MESSAGES(FRUITS) CORRECTLY AND MESSAGES CONSUMED CORRECTLY.
 */

public class ProducerTest {

    @Test
    public void testProduceMessages() throws Exception {
        MessageQueue messageQueue = new MessageQueue(10);
        
        	Producer producer = new Producer(messageQueue, Arrays.asList(new Message("Apple"), new Message("Banana")));

        Thread producerThread = new Thread(producer);
        	producerThread.start();

       
        producerThread.join(); // Wait for the producer to finish

        
        // Validate the messages are in the queue
        assertEquals("Apple", messageQueue.consume().getFruitName(), "First message should be 'Apple'");
        assertEquals("Banana", messageQueue.consume().getFruitName(), "Second message should be 'Banana'");
    }
}
