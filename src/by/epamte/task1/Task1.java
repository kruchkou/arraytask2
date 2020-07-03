package by.epamte.task1;

public class Task1 {

    private static int[][] matrix(int n) {
        int[][] matrix = new int[n][n];

        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int colIndex = 0; colIndex < n; colIndex++) {

                if (rowIndex % 2 == 0) {
                    matrix[rowIndex][colIndex] = colIndex + 1;
                } else {
                    matrix[rowIndex][colIndex] = n - colIndex;
                }
            }
        }
        return matrix;
    }

    public static String matrixToString(int[][] matrix) {
        StringBuilder result = new StringBuilder();

        for (int[] rows : matrix) {
            for (int element : rows) {
                result.append(element).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int n = 6;

        System.out.println(matrixToString(matrix(n)));
    }
}
