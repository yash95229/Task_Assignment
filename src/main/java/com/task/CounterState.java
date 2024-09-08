package com.task;

import java.util.concurrent.atomic.AtomicInteger;

/*
 
 PURPOSE OF THIS CLASS IS JUST TO COUNT SUCCESS AND ERROR MESSAGES
 
 */
public class CounterState {
	 
	private final AtomicInteger successCount = new AtomicInteger();
	private final AtomicInteger errorCount = new AtomicInteger();

	    public void incrementSuccess() {
	        successCount.incrementAndGet();
	    }

	    public void incrementError() {
	        errorCount.incrementAndGet();
	    }

	    public int getSuccessCount() {
	        return successCount.get();
	    }

	    public int getErrorCount() {
	        return errorCount.get();
	    }
}

   

