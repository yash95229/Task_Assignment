package com.task.trackMessageQueue;

/*
 
PURPOSE OF THIS CLASS TO REPRESENT A MESSAGE WITH A STATUS

 */
public class Message {
    private final String fruitName;

    public Message(String fruitName) {
        this.fruitName = fruitName;
    }

   // Returns the status of the message which is fruits
    public String getFruitName() {
        return fruitName;
    }

    @Override
    public String toString() {
    	 return String.format(" "+"Current Fruit :> '%s'", fruitName);
    }
}
