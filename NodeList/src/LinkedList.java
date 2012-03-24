public class LinkedList {

	public static void addNode(Node node, Node newNode) {
		newNode.nextNode = node.nextNode;
		node.nextNode = newNode;
	}

	public static void deleteNode(Node head, Object value) {
		Node node = null;
		Node prevNode = null;
		Node delNode = null;
		while (node != null) {
			if (node.value != null && node.value.equals(value)) {
				delNode = node;
				break;
			} else {
				prevNode = node;	
			}			
			node = node.nextNode;
		}
		prevNode.nextNode = delNode.nextNode;
		delNode.nextNode = null;
	}
	
	public static Node reverseList(Node head) {
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
	

	public static Node findNode(Object value, Node node) {
		Node ret = null;
		while (node != null) {
			if (node.value != null && node.value.equals(value)) {
				System.out.println("-------------------------------");
				System.out.println("The node is " + node.value);
				ret = node;
				break;
			}
			node = node.nextNode;
		}
		return ret;
	}

	public static void main(String[] args) {
		String name = "c";
		String name1 = "b";
		String name2 = "a";
		Node head = new Node();
		Node last = new Node(name);
		Node second = new Node(name1, last);
		Node first = new Node(name2, second);
		head.nextNode = first;
		Node sNode = new Node("s");
		Node eNode = new Node("e");
		Node xNode = new Node("x");
//		printNodes(head);
		addNode(first, sNode);
//		addNode(second, eNode);
//		addNode(sNode, xNode);
		printNodes(head);
//		deleteNode(head, "b");
//		printNodes(head);
//		findNode("x", head);
		Node newHead = reverseList(head);
		printNodes(newHead);
	}

	static void printNodes(Node node) {
		System.out.println("\n-------------------------------");

		while (node != null) {
//			System.out.println("This node is " + node.value);
			System.out.print(node.value+" -> ");
			node = node.nextNode;
		}
	}
}