package arithmetic.exercise.medium.sort;

/**
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 */
public class SearchMatrix {

    private static boolean exist(int[][] board, int target) {

        int[] firstRow = board[0];
        if (board[0][0] > target) {
            return false;
        }
        if (board[0][0] == target) {
            return true;
        }
        int currentCol = searchRow(firstRow, 0, firstRow.length, target);
        if (board[0][currentCol] == target) {
            return true;
        }
        int rowStart = 0;
        int rowEnd = board.length;
        while (currentCol >= 0) {
            int row = searchCol(board, currentCol, rowStart, rowEnd, target);
            if (board[row][currentCol] == target) {
                return true;
            }
            rowStart = row;
            currentCol--;
        }
        return false;
    }

    private static int searchRow(int[] arr, int start, int end, int target) {
        int low = start;
        int high = end - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low - 1;
    }

    private static int searchCol(int[][] board, int col, int rowStart, int rowEnd, int target) {
        int low = rowStart;
        int high = rowEnd - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = board[mid][col];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low - 1;
    }

    /**
     * 从左下或右上开始搜索（因为左上是最小值，右下是最大值，无法决定下一步的方向）
     * 以左下为例，如果比target小，向右移动。如果比target大，向上移动
     */
    private static boolean solution4(int[][] board, int target) {
        int x = board.length - 1;
        int y = 0;
        while (x >= 0 && y < board[0].length) {
            if (board[x][y] == target) {
                return true;
            } else if (board[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] board = new int[][] {
            {1,  4,  7,  11,  15},
            {2,  5,  8,  12,  19},
            {3,  6,  9,  16,  22},
            {10, 13, 14, 17,  24},
            {18, 21, 23, 26,  30}
        };
        System.out.println(exist(board, 5));
        System.out.println(exist(board, 16));
        System.out.println(exist(board, 20));
        System.out.println(exist(board, 23));
        System.out.println(exist(board, 25));
    }

}
