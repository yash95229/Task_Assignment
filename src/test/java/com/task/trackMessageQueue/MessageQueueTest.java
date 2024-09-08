package com.task.trackMessageQueue;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

/*
  		PURPOSE	OF THIS TEST VERIFY THE MESSAGES ARE CORRECTLY PRODUCED AND CONSUMED BY TESTING WITH MULTIPLE THREADS.	
 */
public class MessageQueueTest {

    @Test
  public void testProduceAndConsume() throws Exception {
        MessageQueue messageQueue = new MessageQueue(5);
        CountDownLatch latch = new CountDownLatch(1);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                messageQueue.produce(new Message("Apple"));
                latch.countDown(); // Signal that produce is done
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                Message message = messageQueue.consume();
                assertEquals("Apple", message.getFruitName(), "Consumed message should be 'Apple'");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        // Wait for the producer to finish producing
        latch.await(1, TimeUnit.SECONDS);

        producer.join();
        consumer.join();
    }
}
