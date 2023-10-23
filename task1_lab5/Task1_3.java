package task1_lab5;

public class Task1_3 {
	public static int[][] multiply(int[][] a, int[][] b) {
	    int rowsA = a.length;
	    int columnsA = a[0].length;
	    int columnsB = b[0].length;
	    int[][] result = new int[rowsA][columnsB];
	    for (int i = 0; i < rowsA; i++) {
	        for (int j = 0; j < columnsB; j++) {
	            for (int k = 0; k < columnsA; k++) {
	                result[i][j] += a[i][k] * b[k][j];
	            }
	        }
	    }
	    return result;
	}
	public static void printMatrix(int[][] matrix) {
	    int rows = matrix.length;
	    int columns = matrix[0].length;
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < columns; j++) {
	            System.out.print(matrix[i][j] + " ");
	        }
	        System.out.println();
	    }
	    System.out.println();
	}
	public static void main(String[] args) {
		int[][] a = {{3,7,9},
					{8,1,4}};
		
		int[][] b = {{2,5,1},
					{-4,0,1},
					{8,6,-3}};
		
		printMatrix(multiply(a, b));
	}
}