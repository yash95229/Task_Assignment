package com.task.trackMessageQueue;
import java.util.LinkedList;
import java.util.Queue;

/*

PURPOSE OF THIS CLASS TO MANAGE THE MESSAGES QUEUE AND ALLOW PRODUCERS TO ADD AND CONSUMERS PROCESSED THE MESSAGES
ALSO IN THIS WE HAVE CREATED TWO SYNCHRONIZED METHODS SO THAT ONLY ONE THREAD WILL PROCESS AT A TIME 

*/ 
public class MessageQueue {
	  private final Queue<Message> queue;
	  private final int queueSize;

	    public MessageQueue(int queueSize) {
	        queue = new LinkedList<>();   // this linklist will contains whole messages
	        this.queueSize = queueSize;
	    }

	    //Adds a message :::>  if there is a space. 
	    //If the queue is full ::> it waits for consumer.
	     public synchronized void produce(Message message) throws Exception {
	        while (queue.size() == queueSize) {
	            System.out.println("Messges ::> full, Producer Waiting for Consumer");
	            wait();
	        }
	        queue.add(message);
	         notify();
	        System.out.println("Produced :>" + message);
	    }

	   //Retrieves and removes a message ::> if it's not empty. 
	   //If the queue is empty ::> it waits for producer.

	    public synchronized Message consume() throws Exception {
	        while (queue.isEmpty()) {
	            System.out.println("Messages ::> Empty, Consumer Waiting for Producer");
	           wait();
	        }
	        Message message = queue.poll();
	        System.out.println("Consumed :>" + message);
	       notify();
	        return message;
	    }
}
