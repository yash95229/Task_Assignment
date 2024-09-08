
ASSIGNMENT:

	A MESSAGE DRIVEN APP
	
	Overview:
	
	This program involves three main components:
  (Here Messages are passing as a fruit names)
	Producer: Generates messages and puts them into a message queue.
	Consumer: Takes messages from the queue and processes them.
	MessageQueue: Manages the queue where messages are stored temporarily.
	
	Program Flow
	
	Producer Thread:

	Starts producing messages and adds them to the MessageQueue.
	If the queue is full, it waits until space is available.
	After all messages are added, the thread completes.
	
	Consumer Thread:

	Starts consuming messages from the MessageQueue.
	If the queue is empty, it waits until messages are available.
	Processes each message and updates counters for successes and errors.
	Stops when a "END OF THE MESSAGES" message is encountered.
	
	Completion:

	After both threads complete, the main method prints the total count of successfully processed messages and errors encountered.
	
	THIS IS THE OUTPUT OF THE PROGRAM::
	
	
	
	
	TEST CASES:
	
	ProducerTest:
	IMAGE-3
		testProduceMessages: Ensures that the Producer adds messages to the MessageQueue and that these messages can be consumed correctly.
	
	ConsumerTest:
	IMAGE-4
		testConsumeMessages: Checks if the Consumer processes messages and updates the CounterState correctly.	
	
	MessageQueueTest:
	IMAGE-5
		testProduceAndConsume: Verifies that messages are correctly produced and consumed by testing with multiple threads to check synchronization.
	
	MessageTest:
		testGetFruitName: Checks if getFruitName() returns the correct fruit name.
		testToString: Ensures that toString() formats the message correctly.

	CounterStateTest:
		testIncrementSuccess and testIncrementError: Validate that the counts are incremented correctly for success and error cases.

