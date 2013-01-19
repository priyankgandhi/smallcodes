/**
 * 
 */
package com.techstudio.sorting;

import java.util.Arrays;
import java.util.List;

/**
 * @author priyank
 * 
 */
public class QuickSort {

	public static void main(String[] args) {
		Integer[] array = { 25, 4, 3, 35, 14, 19, 2 };
		processArray(array);

		Integer[] array2 = { 1, 88, 12, 35, 12, 67, 12, 16, 19, 20, 6, 9, 8 };
		processArray(array2);
	}

	public static void processArray(Integer[] array) {
		List<Integer> arrayList = Arrays.asList(array);
		System.out.println("Before: " + Arrays.toString(arrayList.toArray()));
		sort(arrayList);
		System.out.println("After: " + Arrays.toString(arrayList.toArray()));
	}

	public static void sort(List<Integer> array) {
		int pivot = array.size() / 2;
		int left = 0;
		int right = array.size() - 1;
		int pivotNumber = array.get(pivot);
		// System.out.println("Processing: " + Arrays.toString(array.toArray())
		// + " with pivot: "+pivotNumber );
		while (left != right) {
			int a = array.get(left);
			int b = array.get(right);

			if (a < pivotNumber) {
				left++;
			}
			if (b > pivotNumber) {
				right--;
			}
			if (a >= pivotNumber && b <= pivotNumber) {
				int temp = array.get(left);
				array.set(left, array.get(right));
				array.set(right, temp);
				left++;
			}
		}

		// System.out.println("Pivot index: " +left);

		List<Integer> leftArray = array.subList(0, left);
		if (leftArray.size() != 0) {
			sort(leftArray);
		}

		List<Integer> rightArray = array.subList(left + 1, array.size());
		if (rightArray.size() != 0) {
			sort(rightArray);
		}
	}

}
