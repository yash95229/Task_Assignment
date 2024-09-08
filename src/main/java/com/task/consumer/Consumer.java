package com.task.consumer;

import com.task.CounterState;
import com.task.trackMessageQueue.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/*
 
 PURPOSE OF THIS CLASS TO CONSUMES MESSAGES (WHICH ARE FRUITS HERE) AND PROCESSES THEM.
 
 */
public class Consumer implements Runnable {
    private final MessageQueue messageQueue;
    private final AtomicReference<CounterState> counterState;

    public Consumer(MessageQueue messageQueue, AtomicReference<CounterState> counterState) {
        this.messageQueue = messageQueue;
        
        //Counters to keep track of successful and failed message processing.
        this.counterState = counterState;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = messageQueue.consume();
                
                //END OF THE MESSAGES
                if (message.getFruitName().equals("END OF THE MESSAGES")) {
                    break;
                }
                processMessage(message);
                counterState.get().incrementSuccess();
            } catch (Exception e) {
            	counterState.get().incrementError();
            }
        }
    }

    private void processMessage(Message message) {
        String fruitName = message.getFruitName();
        
        // THIS IS JUST THE CONDITION TO CHECK THE FAILED SCENARIO
        if (fruitName == null || fruitName.isEmpty()) {
            throw new RuntimeException("Failed to process message: " + message);
        }

        System.out.println("Successfully Processed : " + message);
    }
}
