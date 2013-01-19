import java.util.*;

public class Anagrams {
	public static void main(String args[]) throws Exception {
		String input = "test";
		String chars = input;
		showPattern("", chars);
	}

	public static void showPattern(String st, String chars) {
		if (chars.length() <= 1)
			System.out.println(st + chars);
		else
			for (int i = 0; i < chars.length(); i++) {
				try {
					String newString = chars.substring(0, i)
							+ chars.substring(i + 1);
					showPattern(st + chars.charAt(i), newString);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
	}
}
