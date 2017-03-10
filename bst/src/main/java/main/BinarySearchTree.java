package main;
public class BinarySearchTree {

	static BinaryNode rootNode;

	public BinarySearchTree() {
		rootNode = null;
	}

	public void insert(Object x) {
		if(rootNode == null) {
			rootNode = new BinaryNode();
			rootNode.item = x;
		} else {
			BinaryNode node = rootNode;
			while (node != null) {
				if (((Comparable) x).compareTo(node.item) <= 0) {
					if(node.leftNode == null) {
						node.leftNode = new BinaryNode(x);
						break;
					} else {
						node = node.leftNode;
					}					
				} else {
					if(node.rightNode == null) {
						node.rightNode = new BinaryNode(x);
						break;
					} else {
						node = node.rightNode;
					}
				}
			}			
		}		
	}
	
	//traversals
	
	//in-order left-root-right
	public void inOrder() {
		System.out.println("\nin-order left-root-right");		
		if(rootNode == null) {
			return;
		} else {
			inOrderTraversal(rootNode);			
		}		
	}
	
	public void inOrderTraversal(BinaryNode node) {		
		if (node.leftNode != null) {			
			inOrderTraversal(node.leftNode);
		} 
		System.out.print(node.item + " ");		
		if (node.rightNode != null) {			
			inOrderTraversal(node.rightNode);
		}		
	}
	
	//pre-order root-left-right
	public void preOrder() {
		System.out.println("\npre-order root-left-right");
		if(rootNode == null) {
			return;
		} else {
			preOrderTraversal(rootNode);			
		}		
	}
	
	public void preOrderTraversal(BinaryNode node) {
		System.out.print(node.item + " ");
		if (node.leftNode != null) {
			preOrderTraversal(node.leftNode);
		}
		if (node.rightNode!=null){
			preOrderTraversal(node.rightNode);
		}
	}
	
	
	//post-order left-right-root
	public void postOrder() {
		System.out.println("\npost-order left-right-root");
		if(rootNode == null) {
			return;
		} else {
			postOrderTraversal(rootNode);			
		}		
	}
	public void postOrderTraversal(BinaryNode node) {
		if (node.leftNode != null){
			postOrderTraversal(node.leftNode);
		}
		if(node.rightNode != null) {
			postOrderTraversal(node.rightNode);
		}
		System.out.print(node.item + " ");
	}
	
	// find min - left most node
	public BinaryNode findMin(BinaryNode node) {
		while (node.leftNode!=null) {
			node = node.leftNode;
		}
		return node;
	}
	
	// find max - right most node
	public BinaryNode findMax(BinaryNode node) {
		while (node.rightNode!=null) {
			node = node.rightNode;
		}
		return node;
	}	
	
	public void delete(int x) {
		deleteNode(x, null, rootNode);
		System.out.println(rootNode);		
	}
	
	private void deleteNode(Integer x, BinaryNode parent, BinaryNode node) {
		Integer nodeValue = (Integer) node.item;
		if (x < nodeValue) {			
			deleteNode(x, node, node.leftNode);			
		} else if (x > nodeValue) {
			deleteNode(x, node, node.rightNode);
		} else {
			boolean isLeftNode = parent != null && parent.leftNode != null  && parent.leftNode == node;
			if (node.leftNode != null && node.rightNode != null) {
				System.out.println("test "+node.item);
				node.item = findMinValue(node.rightNode);				
				deleteNode((Integer)node.item, node, node.rightNode);
			} else if (node.leftNode != null) {
				if(parent == null) {
					node = node.leftNode;
				} else if (isLeftNode) {
					parent.leftNode = node.leftNode;
				}
				else {
					parent.rightNode = node.leftNode;
				}
				
			} else {
				if(parent == null) {
					node = node.rightNode;
				} else if (isLeftNode) {
					parent.leftNode = node.rightNode;
				}
				else {
					parent.rightNode = node.rightNode;
				}
			}			
		}		
	}
	
	private Object findMinValue(BinaryNode node) {
		if (node.leftNode == null) {
			Object item = node.item;
			return item;
		} else {
			return findMinValue(node.leftNode);
		}		
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
	
	// find depth of binary tree
	public int findDepth() {
		return 	findDepthFromNode(rootNode);
	}
	
	public int findDepthFromNode(BinaryNode node) {
		if(node == null) {
			return 0;
		} else {
			int lDepth = findDepthFromNode(node.leftNode);
		    int rDepth = findDepthFromNode(node.rightNode);

		    int maxD = Math.max(lDepth, rDepth) + 1;
//		    System.out.print("current node: " + node);		
//			System.out.println(" max level: " + maxD);	
		    return(maxD);	
		}
	}
	
	
	public int size() {
		return traverseNodes(rootNode, 0);
	}
	
	public int traverseNodes(BinaryNode node, int c) {
		if(node.leftNode != null) {			
			c = traverseNodes(node.leftNode, c);
		}
		System.out.print(node.item + ",");
		c++;
 		if(node.rightNode != null) {			
			c = traverseNodes(node.rightNode, c);
		}
		return c;
	}
	
	// mirror binary tree
	public void mirrorTree() {
		mirrorTree(rootNode);
	}
	
	public void mirrorTree(BinaryNode node) {
		if(node == null) {
			return;
		}
		mirrorTree(node.leftNode);	
		mirrorTree(node.rightNode);
		
		BinaryNode temp = node.leftNode;
		node.leftNode = node.rightNode;
		node.rightNode = temp;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		inorderToString(rootNode, sb);
		return sb.toString();	
	}
	
	public void inorderToString(BinaryNode node, StringBuffer sb) {
		if(node == null) return; 
		inorderToString(node.leftNode, sb);
		sb.append(node.toString());
		inorderToString(node.rightNode, sb);
	}
	
	
//						8
//			6						15
//		2		7			9
//			5					10

	public static void main(String[] args) {
		System.out.println("Building binary tree");
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(8); bst.insert(6);
		bst.insert(15); bst.insert(7);
		bst.insert(2); bst.insert(9);
		bst.insert(10); bst.insert(5);
		bst.inOrder();
		bst.preOrder();
		bst.postOrder();
		System.out.println("\n\nValid binary tree: "+ bst.isValidBST());		
		int depth = bst.findDepth();
		System.out.println("\nDepth of this tree: " + depth);
		bst.mirrorTree();	
		int size = bst.size();
		System.out.println("Size of btree "+ size);
	}
}
