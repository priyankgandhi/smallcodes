import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author mrunal
 * 
 */
public class StringManipulation {
	/*
	 * input is an array and a numeric number. From the array find pairs whose
	 * sum equals to input numeric number
	 */

	public static void findPairs(Integer[] a, int n) {
		int c = 0;
		for (int i = 0; i <= a.length - 1; i++) {
			for (int j = i + 1; j <= a.length - 1; j++) {
				c++;
				int f = a[i] + a[j];
				if (f == 11) {
					System.out.println("The pair is " + a[i] + " " + a[j]);
				}
			}
		}
		System.out.println("Loop count is " + c);
	}

	/*
	 * Write code to ignore duplicates in a string of characters.
	 */

	public static void ignoreDuplicates(String s) {
		// List<String> cList = Arrays.asList(s.split(""));
		StringBuffer resultBuf = new StringBuffer();
		StringBuffer dupBuf = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			String ch = s.substring(i, i + 1);
			String res = s.substring(i + 1);

			// prints slbh - removes chars that have dupes
			if (res.lastIndexOf(ch) == -1 && dupBuf.lastIndexOf(ch) == -1) {
				resultBuf.append(ch);
			} else {
				dupBuf.append(ch);
			}

			// prints salbh - removes duplicate char keeps first occurence
			if (res.lastIndexOf(ch) == -1) {
				resultBuf.append(ch);
			}

			// prints slabh - removes duplicate char keeps last occurence
			if (res.lastIndexOf(ch) == -1 && resultBuf.lastIndexOf(ch) == -1) {
				resultBuf.append(ch);

			}

		}
		System.out.println("Non Duplicates are " + resultBuf.toString());
	}

	public static void main(String[] args) {
		String strLine = "Java Reverse string by word example";
		// Output: example word by string Reverse Java 
		// specify delimiter as " " space
		String[] words = strLine.split(" ");
		String[] chars = strLine.split("");
//		char[] array = strLine.toCharArray();
		StringBuffer buf = new StringBuffer();
		for (int i=chars.length-1;i>=0;i--) {
			buf.append(chars[i]);
		}
		System.out.println(buf.toString());


//		StringTokenizer st = new StringTokenizer(strLine, "");
//		String strReversedLine = "";
//		while (st.hasMoreTokens()) {
//			strReversedLine = st.nextToken() + " " + strReversedLine;
//		}
//		System.out.println("Reversed string by word is : " + strReversedLine);
//		
//		Integer[] array1 = { 2, 9, 6, 1, 8, 5 };
//		int n = 11;
//		String s = "salabh";
//		// findPairs(array1, n);
//		ignoreDuplicates(s);
	}

}
