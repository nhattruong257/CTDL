package task2_lab4;

import java.util.Arrays;

public class Task2_1_lab4 {
	public static void mergeSort(int[] arr, int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			// Sắp xếp nửa đầu của mảng
			mergeSort(arr,l,mid);
			// Sắp xếp nửa sau của mảng
			mergeSort(arr,mid+1,r);
			// Gộp hai nửa đã sắp xếp lại
			merge(arr,l,mid,r);
		}
	}
	public static void merge(int[] arr, int l, int mid, int r) {
		 int leftLength = mid - l + 1;
		    int rightLength = r - mid;
		    
		    // Tạo mảng tạm để chứa giá trị của hai nửa mảng
		    int[] leftArray = new int[leftLength];
		    int[] rightArray = new int[rightLength];
		    
		    // Sao chép giá trị từ mảng ban đầu sang mảng tạm
		    for (int i = 0; i < leftLength; i++) {
		        leftArray[i] = arr[l + i];
		    }
		    for (int j = 0; j < rightLength; j++) {
		        rightArray[j] = arr[mid + 1 + j];
		    }
		    
		    // Gộp hai nửa mảng lại theo thứ tự giảm dần
		    int i = 0, j = 0, k = l;
		    while (i < leftLength && j < rightLength) {
		        if (leftArray[i] >= rightArray[j]) {
		            arr[k] = leftArray[i];
		            i++;
		        } else {
		            arr[k] = rightArray[j];
		            j++;
		        }
		        k++;
		    }
		    
		    // Sao chép phần còn lại của nửa mảng trái (nếu có)
		    while (i < leftLength) {
		        arr[k] = leftArray[i];
		        i++;
		        k++;
		    }
		    
		    // Sao chép phần còn lại của nửa mảng phải (nếu có)
		    while (j < rightLength) {
		        arr[k] = rightArray[j];
		        j++;
		        k++;
		    }
		}
	public static void main(String[] args) {
		int[] arr = {4,2,6,1,7};
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}

