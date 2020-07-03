package by.epamte.task2;

import static by.epamte.task1.Task1.matrixToString;

public class Task2 {

    private static int[][] matrix(int n) {
        int[][] matrix = new int[n][n];

        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            matrix[rowIndex][rowIndex] = (rowIndex + 1) * (rowIndex + 2);
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(matrixToString(matrix(n)));
    }
}
