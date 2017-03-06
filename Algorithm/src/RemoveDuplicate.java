import java.util.Arrays;

public class RemoveDuplicate {
	
	public static int removeDuplicates(int[] nums) {

		int i = 1; // iterator thru array
		int j = 0; // current index
		for (; i < nums.length; i++) {
			if (nums[i] != nums[j]) { // new number
				j++; // move current index
				nums[j] = nums[i]; // fill current index with new number
			}
		}
		return j + 1;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,3,3,4};
		System.out.println(Arrays.toString(nums));
		System.out.println("Length " +removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
}
