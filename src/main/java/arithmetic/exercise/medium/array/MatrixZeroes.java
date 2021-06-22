package arithmetic.exercise.medium.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 矩阵置零
 *
 * 给定一个m x n的矩阵，如果一个元素为0，则将其所在行和列的所有元素都设为0，请使用原地算法
 */
public class MatrixZeroes {

    private static void solution(int[][] matrix) {
        Set<Integer> zeroRowLocation = new HashSet<>();
        Set<Integer> zeroColumnLocation = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRowLocation.add(i);
                    zeroColumnLocation.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (zeroRowLocation.contains(i) || zeroColumnLocation.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        // [[1, 1, 1], [1, 0, 1], [1, 1, 1]]  => [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
        // [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]] => [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution(matrix1);
        for (int i = 0; i < matrix1.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }
    }

}
