package Task1;


public class Task1_3 {
    // This method is used to display a Pascal triangle based on the parameter row.
    // Where row represents the number of rows
    public static void printPascalTriangle(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(getPascalValue(i, j) + " " );
            }
            System.out.println();
        }
    }

    // get the nth row.
    // For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
    public static int[] getPascalTriangle(int n) {
        int[] pascalRow = new int[n];
        for (int i = 0; i < n; i++) {
            pascalRow[i] = getPascalValue(n - 1, i);
        }
        return pascalRow;
    }

    // generate the next row based on the previous row
    // Ex. prevRow = {1} ==> nextRow = {1, 1}
    // Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
    public static int[] generateNextRow(int[] prevRow) {
        int n = prevRow.length + 1;
        int[] nextRow = new int[n];
        nextRow[0] = 1;
        for (int i = 1; i < n - 1; i++) {
            nextRow[i] = prevRow[i - 1] + prevRow[i];
        }
        nextRow[n - 1] = 1;
        return nextRow;
    }

    // Helper method to calculate the value at a specific position in Pascal's Triangle
    private static int getPascalValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        } else {
            return getPascalValue(row - 1, col - 1) + getPascalValue(row - 1, col);
        }
    }

    public static void main(String[] args) {
        int row = 5;
        System.out.println("Pascal Triangle:");
        printPascalTriangle(row);

        int n = 4;
        int[] pascalRow = getPascalTriangle(n);
        System.out.println("\nRow "  + n +  " of Pascal Triangle:");
        for (int num : pascalRow) {
            System.out.print(num + " " );
        }

        int[] prevRow = {1, 2, 1};
        int[] nextRow = generateNextRow(prevRow);
        System.out.println("\n\nNext Row based on {1, 2, 1}:");
        for (int num : nextRow) {
            System.out.print(num + " " );
        }
    }
}



