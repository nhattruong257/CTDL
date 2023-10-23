package task1_lab5;

public class Task1_4 {
	public static int[][] transpose(int[][] a) {
	    int rows = a.length;
	    int columns = a[0].length;
	    int[][] result = new int[columns][rows];
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < columns; j++) {
	            result[j][i] = a[i][j];
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
		int[][] matrix = {{3,7,9},
						{8,1,4}};
		
		printMatrix(transpose(matrix));
	}
}