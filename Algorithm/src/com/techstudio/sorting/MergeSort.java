/**
 * 
 */
package com.techstudio.sorting;

/**
 * @author priyank
 * 
 */
public class MergeSort {

	int[] array = { 25, 4, 3, 35, 14, 19, 2 };
	int[] helper = new int[array.length];

	public void mergesort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	public void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			array[k] = helper[i];
			k++;
			i--;
		}
	}

}
