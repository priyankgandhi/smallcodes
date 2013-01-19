import java.util.ArrayList;
import java.util.List;

/**
 * @author priyank
 * Scenario:
 * There are 1000 bottles. One of them is poisoned.
 * You have nine tasters. Find which one is poisoned.
 * Sample output:
 * Taster 0 Total bottles to taste 500
 * Taster 1 Total bottles to taste 250
 * Taster 2 Total bottles to taste 125
 * Taster 3 Total bottles to taste 62
 * Taster 4 Total bottles to taste 31
 * Taster 5 Total bottles to taste 16
 * Taster 6 Total bottles to taste 8
 * Taster 7 Total bottles to taste 4
 * Taster 8 Total bottles to taste 2
 * Taster 9 Total bottles to taste 1
 * ----------------------------------
 * Bottle found as it contained false
 * Total tasters used: 10
 */
public class WinePuzzle {
	
	public static void main(String[] args) {
		List<Boolean> list = new ArrayList<Boolean>();		
		for(int i = 0; i<1000;i++ ) {
			list.add(true);
		}
		list.set(999, false); // this is a poisoned bottle.
		findBottle(list, 0);
	}
	
	private static void findBottle(List<Boolean> bottles, int taster) {
		if(bottles.size() == 1) {
			System.out.println("----------------------------------");
			System.out.println("Bottle found as it contained " + bottles.get(0));
			System.out.println("Total tasters used: "+ taster);
		} else{
			boolean found = false;
			int size = bottles.size();
			int half = bottles.size()/2;
			System.out.println("Taster "+taster + " Total bottles to taste " + half);
			found = tasteBottle(half, bottles);
			if (found) {
				findBottle(bottles.subList(0, half), ++taster);				
			} else {
				findBottle(bottles.subList(half, size), ++taster);
			}	
		}
		
	}
	
	private static boolean tasteBottle(int half, List<Boolean> bottles) {
		boolean found = false;
		for(int j=0; j<half;j++) {
			if(!bottles.get(j)) {
				found = true;
				break;
			}
		}
		return found;
	}

}
