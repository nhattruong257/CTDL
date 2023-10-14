package task1_lab4;

import java.util.Arrays;

public class Task1_3_lab4 {
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = i; j>0; --j) {
				if(arr[j]<arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		int[] arr = {4,2,6,1,7};
		insertionSort(arr);
	}
}
