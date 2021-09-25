package arithmetic.exercise.todo.senior;

import java.util.Arrays;

/**
 * 螺旋矩阵
 * 给你一个m行n列的矩阵matrix，请按照顺时针顺序，返回矩阵中的所有元素
 * 示例：
 * 输入: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
 * 输出: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * 输入: [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
 * 输出: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 *
 * // TODO  熟悉directions模板解法
 */
public class SpiralMatrix {

    private static int[] spiralMatrix(int[][] matrix) {
        int length = matrix[0].length;
        int width = matrix.length;
        int[] result = new int[length * width];
        int index = 0;
        int maxIndex = result.length - 1;
        int x = 0;
        int y = 0;
        while (x <= length - x - 1 && y <= width - y - 1) {
            for (int m = x; m <= length - x - 1; m++) {     // 上
                result[Math.min(index++, maxIndex)] = matrix[x][m];
            }
            for (int m = y + 1; m <= width - y - 2; m++) {       // 右
                result[Math.min(index++, maxIndex)] = matrix[m][length - y - 1];
            }
            for (int m = length - x - 1; m >= x; m--) {      // 下
                result[Math.min(index++, maxIndex)] = matrix[width - x - 1][m];
            }
            for (int m = width - y - 2; m > y; m--) {
                result[Math.min(index++, maxIndex)] = matrix[m][y];
            }
            x++;
            y++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiralMatrix(new int[][] {{1}})));
        System.out.println(Arrays.toString(spiralMatrix(new int[][] {{1}, {2}})));
        System.out.println(Arrays.toString(spiralMatrix(new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}})));
        System.out.println(Arrays.toString(spiralMatrix(new int[][] {{1, 2}, {3, 4}})));
        System.out.println(Arrays.toString(spiralMatrix(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.toString(spiralMatrix(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})));
        System.out.println(Arrays.toString(spiralMatrix(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}})));
    }
}
