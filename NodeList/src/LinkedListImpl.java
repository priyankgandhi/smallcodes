/**
 * @author priyank
 *
 */
public class LinkedListImpl {

	Node head = null;
	
	public LinkedListImpl() {
		head = new Node();		
	}
	
	
	
	public void add(int x) {
		Node node = new Node(x);
		node.nextNode = head.nextNode;
		head.nextNode = node;
	}
	
	public int size() {
		Node current = head;		
		int i = 0;
		while(current != null && current.nextNode != null) {
			i++;
			current = current.nextNode;
		}
		return i;
	}
	
	
	public void delete(int x) {
		Node current = head;		
		while(current != null && current.nextNode != null) {
			if(!current.nextNode.value.equals(x)) {
				current = current.nextNode;	
			} else {
				current.nextNode = current.nextNode.nextNode;
				break;				
			}			
		}
	}
	
	public Node reverseList() {
		Node node = head.nextNode;
		Node prevNode = head;
		while (node != null) {
			// copy current node to tempNode
			Node tempNode = new Node();
			tempNode.nextNode = node.nextNode;
			tempNode.value = node.value;
			
			// if current node is first node, then first node should be the last node in reverse linked list case 
			// so first's next node will be null
			// else current node should point to prev node, reversing the linked list.  
			if (prevNode == head) {
				node.nextNode = null;
			} else {
				node.nextNode = prevNode;
			}
			
			// previous node becomes curent node. So next node can point back to current node. 
			prevNode = node; 
			
			// actual state of current node was stored in temp node. 
			// It tells what the address of the next node you have to process.
			node = tempNode.nextNode;
		}
		// now you have reach the last node whose next was null. So it head should point to that node. 
		// And it will become a first node. 
		// this completes the process of reversing the linked list.
		head.nextNode = prevNode;
		
		return head;
	}
	//find() is same as delete except deletion part	
	//stack implementation in linkedlist
	//stack is LIFO 
	// means always delete head.next
	// and always insert at head.next
	
}
