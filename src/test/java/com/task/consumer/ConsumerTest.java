package com.task.consumer;

import com.task.CounterState;
import com.task.trackMessageQueue.Message;
import com.task.trackMessageQueue.MessageQueue;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicReference;
import static org.junit.jupiter.api.Assertions.*;

/*
  PURPOSE OF THIS TEST IS CHECK IF THE CONSUMER PROCESS THE MESSAGE AND UPDATE THE COUNTERSTATE CORRECTLY
 */
public class ConsumerTest {

    @Test
    public void testConsumeMessages() throws Exception {
        
    	MessageQueue messageQueue = new MessageQueue(10);
        
        AtomicReference<CounterState> counterState = new AtomicReference<>(new CounterState());

        messageQueue.produce(new Message("Apple"));
        messageQueue.produce(new Message("Banana"));
        messageQueue.produce(new Message("END OF THE MESSAGES"));

        Consumer consumer = new Consumer(messageQueue, counterState);
		    Thread consumerThread = new Thread(consumer);
		   consumerThread.start();
       
        	consumerThread.join(); // Wait for consumer to finish

        CounterState state = counterState.get();
      
        assertEquals(2, state.getSuccessCount(), "Should have processed 2 successful messages");
        assertEquals(0, state.getErrorCount(), "Should have encountered 0 errors");
    }
}
