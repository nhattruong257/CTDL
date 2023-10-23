package task1_lab5;

public class Task1_2 {
	public static int[][] subtract(int[][] a, int[][] b) {
	    int rows = a.length;
	    int columns = a[0].length;
	    int[][] result = new int[rows][columns];
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < columns; j++) {
	            result[i][j] = a[i][j] - b[i][j];
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
		int[][] a = {{3,7},
					{8,1}};
		
		int[][] b = {{2,5},
					{8,6}};
		
		printMatrix(subtract(a, b));
	}
}