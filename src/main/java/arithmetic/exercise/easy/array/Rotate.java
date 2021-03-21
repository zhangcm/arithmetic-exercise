package arithmetic.exercise.easy.array;

import java.util.Arrays;

public class Rotate {

    /**
     * 辅助数组
     */
    private static void solution1(int[][] matrix) {
        int size = matrix.length;
        if (size == 1) {
            return;
        }
        int[][] newMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int newJ = i;
                int newI = size - 1 - j;
                matrix[i][j] = newMatrix[newI][newJ];
            }
        }
    }

    /**
     * 原地旋转
     * @param matrix
     */
    private static void solution2(int[][] matrix) {
        int size = matrix.length;
        if (size == 1) {
            return;
        }
        int[][] newMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int newJ = i;
                int newI = size - 1 - j;
                matrix[i][j] = newMatrix[newI][newJ];
            }
        }
    }

    /**
     * 先左右翻转，再对角翻转
     */
    private static void solution3(int[][] matrix) {
        int size = matrix.length;
        if (size == 1) {
            return;
        }
        int temp;
        // 左右翻转
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                temp = matrix[i][size - 1 - j];
                matrix[i][size - 1 -j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // 对角翻转
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                temp = matrix[size - 1 - j][size - 1 - i];
                matrix[size - 1 - j][size - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        solution3(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}