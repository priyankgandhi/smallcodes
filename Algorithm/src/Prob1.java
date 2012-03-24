import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * Given a list of integer e.g. (1,2,4,5,6,7,8...) Find a pair with a given sum.
 */
public class Prob1 {

	// O(n^2)
	public static void printPairWithSum(int[] list, int sum) {
		boolean found = false;
		for (int i=0; i<list.length; i++) {
			if(found) {
				break;
			}
			for (int j=0; j<list.length; j++) {
				if (list[i] + list[j] == sum) {
					found = true;
					System.out.println(list[i] + " + " + list[j] +" = " + sum);
					return;
				}
			}	
		}
		if(!found) {
			System.out.println("Not found");
		}
	}
	
	// O(n)
	public static void printPairWithSum1(int[] list, int sum) {
		Set<Integer> seen = new HashSet<Integer>();
		for(int i : list) {
			int j = sum - i;
			if(seen.contains(j)) {
				System.out.println(j +" + " + i + " = "+ sum);
				return;
			} else {
				seen.add(i);
			}
		}
		System.out.println("Not found");
	}
	
	
	
	public static void main(String[] args) {
		int[] list = {1,2,3,5,7,8,9,12};
		printPairWithSum(list, 21);
		printPairWithSum1(list, 21);
		printPairWithSum(list, 19);
		printPairWithSum1(list, 19);
	}
}
