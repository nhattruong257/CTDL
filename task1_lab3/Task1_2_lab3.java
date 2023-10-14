package task1_lab3;

import java.util.Arrays;

public class Task1_2_lab3 {
	 private int[] array;

	    public Task1_2_lab3(int[] array) {
	        this.array = array;
	    }

	    // Tìm kiếm nhị phân theo phương pháp lặp
	    public int iterativeBinarySearch(int target) {
	        int left = 0;
	        int right = array.length - 1;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;

	            if (array[mid] == target) {
	                return mid; // Tìm thấy giá trị cần tìm
	            } else if (array[mid] < target) {
	                left = mid + 1; // Giá trị cần tìm nằm ở nửa phải
	            } else {
	                right = mid - 1; // Giá trị cần tìm nằm ở nửa trái
	            }
	        }

	        return -1; // Không tìm thấy giá trị cần tìm
	    }

	    // Tìm kiếm nhị phân theo phương pháp đệ quy
	    public int recursiveBinarySearch(int target) {
	        return recursiveBinarySearchHelper(target, 0, array.length - 1);
	    }

	    private int recursiveBinarySearchHelper(int target, int left, int right) {
	        if (left > right) {
	            return -1; // Không tìm thấy giá trị cần tìm
	        }

	        int mid = left + (right - left) / 2;

	        if (array[mid] == target) {
	            return mid; // Tìm thấy giá trị cần tìm
	        } else if (array[mid] < target) {
	            return recursiveBinarySearchHelper(target, mid + 1, right); // Giá trị cần tìm nằm ở nửa phải
	        } else {
	            return recursiveBinarySearchHelper(target, left, mid - 1); // Giá trị cần tìm nằm ở nửa trái
	        }
	    }
	    public static void main(String[] args) {
	    	 int[] array1 = {12, 5, 8, 3, 9, 2, 7};
	    	 int[] array2 = {2, 5, 7, 8, 9, 12};
	        Task1_2_lab3 myArray = new Task1_2_lab3(array1);
	        Task1_2_lab3 MyArray = new Task1_2_lab3(array2);
	       System.out.println("Mảng chưa sắp xếp: ");
	       System.out.println(Arrays.toString(array1));
	       System.out.println(myArray.iterativeBinarySearch(9));
	       System.out.println(myArray.recursiveBinarySearch(12));
	       System.out.println(myArray.iterativeBinarySearch(5));
	       System.out.println(myArray.recursiveBinarySearch(2));
	       System.out.println("Kết quả này cho thấy thuật toán tìm kiếm nhị phân không hoạt động đúng khi mảng không được sắp xếp."
	       		+ "\n Điều này đảm bảo rằng hàng đợi trước khi sử dụng thuật toán tìm kiếm nhị phân là sắp xếp mảng trước.");
	       System.out.println();
	       System.out.println("Mảng đã sắp xếp: ");
	       System.out.println(Arrays.toString(array2));
	       System.out.println(MyArray.iterativeBinarySearch(7));
	       System.out.println(MyArray.recursiveBinarySearch(12));
	    }
	}