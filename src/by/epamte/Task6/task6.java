package by.epamte.Task6;

import by.epamte.task1.Task1;

import javax.sql.rowset.RowSetWarning;

public class task6 {

    private static boolean isMagicCube(int[][] matrix) {
        final int ROW_SIZE = matrix.length;
        final int DIAGONAL_QUANTITY = 2;
        final int LINES_QUANTITY = ROW_SIZE * 2;
        final int SUMS_QUANTITY = LINES_QUANTITY + DIAGONAL_QUANTITY;
        final int DIAGONAL_SUM_INDEX = SUMS_QUANTITY - 1;
        final int DIAGONAL_SUM2_INDEX = SUMS_QUANTITY - 2;
        int sums[] = new int[SUMS_QUANTITY];

        for (int rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++) {
            for (int colIndex = 0; colIndex < ROW_SIZE; colIndex++) {
                int horizontalSumIndex = rowIndex;
                int verticalSumIndex = ROW_SIZE + rowIndex;

                sums[horizontalSumIndex] += matrix[rowIndex][colIndex];
                sums[verticalSumIndex] += matrix[colIndex][rowIndex];

            }

            sums[DIAGONAL_SUM_INDEX] += matrix[rowIndex][rowIndex];
            sums[DIAGONAL_SUM2_INDEX] += matrix[ROW_SIZE - 1 - rowIndex][ROW_SIZE - 1 - rowIndex];
        }

        if (isSumsSame(sums) && (isNotSameNums(matrix))) {
            return true;
        }

        return false;
    }

    public static boolean isNotSameNums(int[][] cube) {
        final int ROW_SIZE = cube.length;
        final int ROW_LAST_INDEX = ROW_SIZE - 1;
        final int COL_LAST_INDEX = ROW_LAST_INDEX;
        final int ELEM_QUANTITY = ROW_SIZE * ROW_SIZE;
        int lastCheckedElemIndex = 1;

        for (int rowIndex = 0; rowIndex < ELEM_QUANTITY; rowIndex++) {
            for (int colIndex = 0; colIndex < COL_LAST_INDEX; colIndex++) {

                for (int leftElemIndex = lastCheckedElemIndex + rowIndex; leftElemIndex < ELEM_QUANTITY; leftElemIndex++) {
                    final int leftElemRowIndex = leftElemIndex / ROW_SIZE;
                    final int leftElemColIndex = leftElemIndex % ROW_SIZE;

                    if (cube[rowIndex][colIndex] == cube[leftElemRowIndex][leftElemColIndex]) {
                        return false;
                    }
                }
                lastCheckedElemIndex++;
            }
        }
        return true;
    }

    public static boolean isSumsSame(int[] elements) {
        int prevElement = elements[0];

        for (int element : elements) {
            if (prevElement != element) {
                return false;
            }
            prevElement = element;
        }
        return true;
    }

    private static boolean bruteForceElem(int elemNum, int[][] cube) {
        final int ROW_SIZE = cube.length;
        final int ELEMENTS_QUANTITY = ROW_SIZE * ROW_SIZE;
        int colIndex;
        int rowIndex;

        for (int num = 1; num <= ELEMENTS_QUANTITY; num++) {
            rowIndex = (elemNum / ROW_SIZE);
            colIndex = (elemNum % ROW_SIZE);

            if (isMagicCube(cube)) {
                return true;
            }
            cube[rowIndex][colIndex] = num;
            if (elemNum != 0) {
                if (bruteForceElem(elemNum - 1, cube)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String magicCube(int edgeSize) {
        final int LAST_ELEMENT_INDEX = edgeSize * edgeSize - 1;
        int cube[][] = new int[edgeSize][edgeSize];
        boolean isMagicCube = bruteForceElem(LAST_ELEMENT_INDEX, cube);

        return Task1.matrixToString(cube);
    }

    public static void main(String[] args) {
        System.out.println(magicCube(4));
    }
}
