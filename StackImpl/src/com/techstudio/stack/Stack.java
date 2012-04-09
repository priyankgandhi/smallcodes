/**
 * 
 */
package com.techstudio.stack;


/**
 * @author priyank
 * Stack is LIFO
 * Stack operations push, pop, peek, isEmpty all are O(1)
 * Iteration is O(N)
 */

public class Stack {
	
	StackNode topNode;
	int size;
	
	public Stack() {
		topNode = null;
		size = 0;
	}
	
	public void push(int x) {
		if(topNode == null) {
			topNode = new StackNode(x);
		} else {
			StackNode node = new StackNode(x);
			node.nextNode = topNode;
			topNode = node;			
		}
		size++;		
	}
	
	public Integer pop() {
		if(topNode == null) {
			return null;
		} else {
			Integer ret = topNode.item;
			topNode = topNode.nextNode;
			size--;
			return ret;
		}
	}
	
	// returns an item that was added (without removing)
	public Integer peek() {	
		if(topNode == null) {
			return null;
		} else {
			Integer ret = topNode.item;
			return ret;
		}
	}	

}
