package task1_lab3;

public class Task1_1_lab3 {
		private int[] array;

		public Task1_1_lab3(int[] array) {
			this.array = array;
		}

		// To find the index of the target in the array. If the target
		// is not found in the array, then the method returns -1.
		// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
		// Output: 3
		public int iterativeLinearSearch(int target) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == target) {
					return i;
				}
			}
			return -1;
		}

		// To find the index of the target in the array. If the target
		// is not found in the array, then the method returns -1.
		// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
		// Output: -1
		public int recursiveLinearSearch(int target) {
			return recursiveLinearSearch(target, 0);
		}

		private int recursiveLinearSearch(int target, int index) {
			if (index == array.length) {
				return -1;
			}
			if (array[index] == target) {
				return index;
			}
			return recursiveLinearSearch(target, index + 1);
		}

		public static void main(String[] args) {
			int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };	
			Task1_1_lab3 MyArray = new Task1_1_lab3(array);
			int target1 = 2;
			System.out.println(MyArray.iterativeLinearSearch(target1));
			int target2 = 15;
			System.out.println(MyArray.recursiveLinearSearch(target2));

		}
	}

