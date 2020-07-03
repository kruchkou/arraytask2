package by.epamte.task4;

import static by.epamte.task1.Task1.matrixToString;

public class Task4 {

    private static int[][] matrix(int[] array) {
        final int MATRIX_SIZE = array.length;
        int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];

        for (int rowIndex = 0; rowIndex < MATRIX_SIZE; rowIndex++) {
            for (int colIndex = 0; colIndex < MATRIX_SIZE; colIndex++) {
                matrix[rowIndex][colIndex] = (int) Math.pow(array[colIndex], rowIndex);
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(matrixToString(matrix(inputArray)));
    }
}
