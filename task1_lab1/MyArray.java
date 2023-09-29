package task1_lab1;

import java.util.Arrays;

public class MyArray {
	private int[] array;
	public MyArray(int[] array) {
		this.array = array;
	}
	
	//Method mirror that outputs the contents of an array in a 
	//reverse order like a mirror 
	//Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		int[] result = new int[array.length*2];
		for(int i=0; i<array.length; i++) {
			result[i] = array[i];
			result[result.length-i-1] = array[i];
		}
		return result;
	}
	
	// removes all duplicate elements from an array and returns a 
	// new array
	//Input: 1 3 5 1 3 7 9 8
	//Output: 1 3 5 7 9 8
	public int[] removeDuplicates() {
		// Kiểm tra nếu mảng trống hoặc chỉ có một phần tử
		if (array == null || array.length <= 1) {
			return array;
		}

		Arrays.sort(array);		// Sắp xếp mảng

		int index = 1; // Số lượng phần tử duy nhất ban đầu là 1

		// Duyệt qua mảng đã sắp xếp và loại bỏ các phần tử trùng lặp
		for (int i = 1; i < array.length; i++) {
			if (array[i] != array[i - 1]) {
				array[index] = array[i];
				index++;
			}
		}

		int[] result = Arrays.copyOf(array, index);

		return result;
	}
	
	
	// Input: 10 11 12 13 14 16 17 19 20 
	// Output: 15 18

	// in ra mảng các số còn thiếu
	public int[] getMissingValues() {
		int index = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] - array[i - 1] != 1) {
				array[index] = array[i - 1] + 1;
				index++;
			}

		}

		int[] result = Arrays.copyOf(array, index);

		return result;
	}
	

	 public static void main(String[] args) {
		 
		int[] array1 = {1,2,3};
		MyArray Array1 = new MyArray(array1);
		System.out.println(Arrays.toString(Array1.mirror()));
		
		System.out.println();
		
		int[] array2 = {1,3,5,1,3,7,9,8};
		MyArray Array2 = new MyArray(array2);
		System.out.println(Arrays.toString(Array2.removeDuplicates()));
		
		System.out.println();
		
		int[] array3 = {10,11,12,13,14,16,17,19,20};
		MyArray Array3 = new MyArray(array3);
		System.out.println(Arrays.toString(Array3.getMissingValues()));
		
	}
}

