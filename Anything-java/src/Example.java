import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author priyank
 * 
 */
public class Example {
	int x = 1;

	public Example me() {
		return this;
	}

	public void testSampleSet() {

		Set<Integer> exSet = new HashSet<Integer>();
		Set<Set<String>> exSet2 = new HashSet<Set<String>>();

		exSet.add(1);
		exSet.add(2);
		exSet.add(5);

		// convert set to list
		// one way
		List<Integer> exListNew = new ArrayList<Integer>(exSet);

		// second way
		List<Integer> exList = new ArrayList<Integer>();
		Iterator<Integer> it = exSet.iterator();
		while (it.hasNext()) {
			Integer x = it.next();
			exList.add(x);
		}

		List<String> aList = new ArrayList<String>();
		aList.add("dog");
		aList.add("cat");
		aList.add("horse");
		aList.add("horse");
		aList.add("dog");
		aList.add("dog");
		aList.add("tiger");

		// convert list to set
		// one way
		Set aSet = new HashSet(aList);

		// second way
		for (int i = 0; i < aList.size(); i++) {
			String x = aList.get(i);
			aSet.add(x);
		}

		Map<String, Integer> dupCount = new HashMap<String, Integer>();
		for (int i = 0; i < aList.size(); i++) {
			String x = aList.get(i);
			Integer existingCount = dupCount.get(x);
			if (existingCount == null) {
				existingCount = 0;
			} else {
				existingCount = existingCount + 1;
			}
			dupCount.put(x, existingCount);
		}

		Set<String> keySet = dupCount.keySet();
		Iterator<String> it1 = keySet.iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Key " + key + ": " + dupCount.get(key));
		}

	}

	public static void findPairs(Integer[] a, int n) {
		int c = 0;
		
		int maxTotal = 0;
		Integer[] pairWithMaxTotal = {0,0};
		
		for (int i = 0; i <= a.length - 1; i++) {
			for (int j = i + 1; j <= a.length - 1; j++) {
				c++;
				int f = a[i] + a[j];
//				if (f == 11) {
//					System.out.println("The pair is " + a[i] + " " + a[j]);
//				}
				if (maxTotal < f) {
					maxTotal = f;
					pairWithMaxTotal[0] = a[i];
					pairWithMaxTotal[1] = a[j];
				}
				
			}
		}
		System.out.println(pairWithMaxTotal[0]+","+pairWithMaxTotal[1]);
		
		System.out.println("Loop count is " + c);
	}

}
