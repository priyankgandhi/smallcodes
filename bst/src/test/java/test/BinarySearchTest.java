/**
 * 
 */
package test;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import main.BinarySearchTree;

/**
 * @author priyank
 *
 */
public class BinarySearchTest extends TestCase {

	BinarySearchTree bst;
	
	public void setUp() {
		bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(3);
		bst.insert(6);
		bst.insert(9);
	}
	
	@Test
	public void testInsert() {
		System.out.println("Test insert started");
		Assert.assertEquals(bst.toString(), "3569");
		bst.insert(15);
		Assert.assertEquals(bst.toString(), "356915");
		bst.insert(10);
		Assert.assertEquals(bst.toString(), "35691015");
		bst.insert(1);
		bst.insert(4);
		Assert.assertEquals(bst.toString(), "1345691015");
		System.out.println("Trsting insert completed");
	}
	
	
	@Test
	public void testDelete() {
		System.out.println("Test insert started");
		Assert.assertEquals(bst.toString(), "3569");
		bst.insert(1);
		bst.insert(4);
		Assert.assertEquals(bst.toString(), "134569");
		bst.delete(5);
		System.out.println(bst.toString());
		Assert.assertEquals(bst.toString(), "13469");
		System.out.println(bst.toString());
		System.out.println("Trsting insert completed");
	}
	
}
