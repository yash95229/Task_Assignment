package com.task;

import com.task.consumer.*;
import com.task.producer.*;
import com.task.trackMessageQueue.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/*
 
 THIS IS MAIN CLASS OF THE JAVA
 PURPOSE OF THIS CLASS TO INITIALIZES MESSAGES AND CREATES AND STARTS THE THREAD
 
 */
public class Main {
    public static void main(String[] args) {
    	
    	// here i have given the max size 5
        MessageQueue messageQueue = new MessageQueue(5);
        
        // counters for success and failure
        AtomicReference<CounterState> counterState = new AtomicReference<>(new CounterState());

        Thread producerThread = new Thread(new Producer(messageQueue,
        Arrays.asList(new Message("Apple"),new Message("Banana"),new Message("Cherry"), new Message("Date"),
        		new Message("Elderberry"),new Message("Fig"), new Message("Grape"),new Message("Honeydew"),
                new Message("Apple"),new Message(null), new Message(""), new Message("END OF THE MESSAGES"))));

        Thread consumerThread = new Thread(new Consumer(messageQueue, counterState));

        producerThread.start();
        consumerThread.start();

        try {
        	
        	// here join method used to wait for both thread to finish their execution.
        	
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CounterState state = counterState.get();
        System.out.println("Number Of Success Messages:> " + state.getSuccessCount());
        System.out.println("Number Of Errors Messages:> " + state.getErrorCount());
    }
}
