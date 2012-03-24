/**
 * 
 */

/**
 * @author priyank
 *
 */
public class Atoi {

	static int atoi(String str) throws NumberFormatException {
        if (str == null || str.length() == 0) {
            throw new NumberFormatException("null value, Not a valid number");
        }
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            number =number * 10;
            int c = (int) str.charAt(i);
            if (c < 48 || c > 57) {
                throw new NumberFormatException(str + " is not a valid number");
            }
            int cVal = c - 48;
            number = number + cVal;
        }
        return number;
    }
	
	public static void main(String[] args) {
		System.out.println(atoi("12345"));
	}
}
