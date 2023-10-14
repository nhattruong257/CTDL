package task1_lab4;

import java.util.Arrays;

public class Task1_1_lab4 {
	public static void selectionSort(int[] array) {
		for(int i = 0; i < array.length-1; i++) {
			int minIndex = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
		System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args) {
		int[] array = {4,2,6,1,7};
		selectionSort(array);
	}
}
