public class BinarySearchTree {

	static BinaryNode rootNode;

	BinarySearchTree() {
		rootNode = null;
	}

	public void insertNode(Object x) {
		if (rootNode == null) {
			rootNode = new BinaryNode();
			rootNode.item = x;
		} else {
			BinaryNode node = rootNode;
			while (node != null) {
				//
				if (((Comparable) x).compareTo(node.item) <= 0) {
					if (node.leftNode != null) {
						node = node.leftNode;
					} else {
						BinaryNode newNode = new BinaryNode();
						newNode.item = x;
						node.leftNode = newNode;
						node = null;
					}
				} else {
					if (node.rightNode != null) {
						node = node.rightNode;
					} else {
						BinaryNode newNode = new BinaryNode();
						newNode.item = x;
						node.rightNode = newNode;
						node = null;
					}
				}
			}
		}
	}

	public void inOrderTraversal(BinaryNode node) {
		System.out.println("---"+node.item + " is saying: Checking for left node");
		if (node.leftNode != null) {
			System.out.println("Found, going inside left node");
			inOrderTraversal(node.leftNode);
		} 
		System.out.println("Done with left node or no left node left. So printing myself: " +node.item);
		//System.out.println(node.item);		
		System.out.println("Checking for right node now");
		if (node.rightNode != null) {
			System.out.println("Found, going inside right node");
			inOrderTraversal(node.rightNode);
		}
		System.out.println("***"+node.item + " is saying: Done with right node or no right node left. Going to previous state.");
	}
	
	static int sum = 0;
	public void preOrderTraversal(BinaryNode node) {
		System.out.println(node.item);
		sum = sum + (Integer)node.item;
		if (node.leftNode != null) {
			preOrderTraversal(node.leftNode);
		}
		if (node.rightNode!=null){
			preOrderTraversal(node.rightNode);
		}
	}
	
	public void postOrderTraversal(BinaryNode node) {
		if (node.leftNode != null){
		postOrderTraversal(node.leftNode);
		}
		if(node.rightNode != null) {
			postOrderTraversal(node.rightNode);
		}
		System.out.println(node.item);
	}
	
	public BinaryNode findMin(BinaryNode node) {
		while (node.leftNode!=null) {
			node = node.leftNode;
		}
		return node;
	}
	
	public BinaryNode findMax(BinaryNode node) {
		while (node.rightNode!=null) {
			node = node.rightNode;
		}
		return node;
	}
	
	
	
	public void delete(Object x)
	{
		
	}
	
	
	public boolean isValidBST() {		
		return travTree(rootNode, rootNode.item, rootNode.item);		
	}
	
	@SuppressWarnings("unchecked")
	public boolean travTree(BinaryNode node, Object min, Object max) {
		if(node.leftNode != null) {
			if (((Comparable<Object>) node.leftNode.item).compareTo(node.item) <= 0 && ((Comparable<Object>) node.leftNode.item).compareTo(max) < 0) {
				min = node.leftNode.item;
				max = node.item;
				travTree(node.leftNode, min, max);			
			} else {
				System.out.println("left "+node.item +" : "+ node.leftNode.item);
				return false;
			}	
		}
		if(node.rightNode != null) {
			if (((Comparable<Object>) node.rightNode.item).compareTo(node.item) >= 0 && ((Comparable<Object>) node.rightNode.item).compareTo(min) > 0) {
				min = node.item;
				max = node.rightNode.item;
				travTree(node.rightNode, min, max);
			} else {
				System.out.println("right "+ node.item +" : "+ node.rightNode.item);
				return false;
			}			
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertNode(8);
		bst.insertNode(6);
		bst.insertNode(15);
		bst.insertNode(7);
		bst.insertNode(2);
		bst.insertNode(9);
		//bst.inOrderTraversal(rootNode);
		//bst.preOrderTraversal(rootNode);
		//bst.postOrderTraversal(rootNode);
		//System.out.println("*** Sum is " + sum);
		System.out.println(bst.isValidBST()+"");
		
	}
}
