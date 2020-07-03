package by.epamte.task3;

import static by.epamte.task1.Task1.matrixToString;

public class Task3 {

    private static int[][] matrix(int n) {
        final int ARRAY_SIZE = n - 1;
        int[][] matrix = new int[n][n];

        for (int rowIndex = 0; rowIndex <= ARRAY_SIZE; rowIndex++) {
            if (rowIndex < (n / 2)) {
                for (int colIndex = rowIndex; colIndex < n - rowIndex; colIndex++) {
                    matrix[rowIndex][colIndex] = 1;
                }
            } else {
                for (int colIndex = ARRAY_SIZE - rowIndex; colIndex <= ARRAY_SIZE - (ARRAY_SIZE - rowIndex); colIndex++) {
                    matrix[rowIndex][colIndex] = 1;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(matrixToString(matrix(n)));
    }
}
