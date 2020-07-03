package by.epamte.task5;

import static by.epamte.task1.Task1.matrixToString;

public class Task5 {

    private static int randomNum(int fromNum, int toNum) {
        return fromNum + (int) (Math.random() * toNum);
    }

    private static int[][] randomMatrix(int n, int m) {
        int[][] matrix = new int[n][m];

        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int colIndex = 0; colIndex < m; colIndex++) {
                matrix[rowIndex][colIndex] = randomNum(1, 9);
            }
        }

        return matrix;
    }

    private static int[][] mulMatrix(int[][] matrixA, int[][] matrixB) {
        final int RES_ROW_SIZE = matrixA.length;
        final int RES_COL_SIZE = matrixB[0].length;
        final int ELEM_IN_SUM_QUANTITY = matrixA[0].length;
        int[][] result = new int[RES_ROW_SIZE][RES_COL_SIZE];

        for (int resRowIndex = 0; resRowIndex < RES_ROW_SIZE; resRowIndex++) {
            for (int resColIndex = 0; resColIndex < RES_COL_SIZE; resColIndex++) {
                for (int elemIndex = 0; elemIndex < ELEM_IN_SUM_QUANTITY; elemIndex++) {
                    result[resRowIndex][resColIndex] += matrixA[resRowIndex][elemIndex] * matrixB[elemIndex][resColIndex];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrixA = randomMatrix(3, 4);
        int[][] matrixB = randomMatrix(4, 5);

        System.out.println(matrixToString(matrixA));
        System.out.println(matrixToString(matrixB));
        System.out.println(matrixToString(mulMatrix(matrixA, matrixB)));
    }
}
