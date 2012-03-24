/**
 * 
 */

/**
 * Write a program to determine whether an input string x is a substring of another input string y. 
 * @author priyank
 */
public class SubstringCheck {

	static boolean substrChk(String s1, String s2) {
		if(s2.contains(s1)) {
			return true;
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "beautiful";
		String s2 = "beautifully";
		System.out.println(substrChk(s1, s2));
	}
}
