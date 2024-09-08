package com.task.producer;

import com.task.trackMessageQueue.*;
import java.util.List;

/*
  PURPOSE OF THIS CLASS TO GENERATE THE MESSAGES AND ADD THEM INTO MESSAGEQUEUE
 */
public class Producer implements Runnable {
    private final MessageQueue messageQueue;
    private final List<Message> messages;

    public Producer(MessageQueue messageQueue, List<Message> messages) {
        this.messageQueue = messageQueue;
        this.messages = messages;
    }

    @Override
    public void run() {
        for (Message message : messages) {
            try {
                messageQueue.produce(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
