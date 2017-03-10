package main;
public class BinaryNode {

	Object item;
	BinaryNode leftNode;
	BinaryNode rightNode;

	public BinaryNode() {}
	
	public BinaryNode(Object item) {
		this.item = item;
	}
	
	@Override
	public String toString() {
		return item.toString();		
	}
	
}
