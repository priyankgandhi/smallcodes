/**
 * 
 */
package com.techstudio.queue;

/**
 * @author priyank
 *
 * This is an implementation of Queue using LinkedList.
 * Queue is FIFO. 
 * It supports enqueue(push), dequeue(pop)
 */
public class Queue {
	
	QueueNode firstNode;
	QueueNode lastNode;
	int size;
	
	public Queue() {
		firstNode = null;
		lastNode = null;		
		size = 0;
	}
	
	//add element to last node (which was added last)
	public void enqueue(Integer x) {
		QueueNode node = new QueueNode(x);		
		if(lastNode == null) {
			firstNode = node;
			lastNode = node;
		} else {
			lastNode.next = node;
			lastNode = node;
		}		
		size++;
	}
	
	public void dequeue() {
		if(firstNode == null) {
			throw new RuntimeException("Empty queue");
		} else {
			firstNode = firstNode.next;
			size--;
		}
	}
	
	
}
