package arithmetic.exercise.medium.dp;

/**
 * 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角（起始点在图中标记位"Start"）。机器人每次只能向下或者向右移动一步。
 * 机器人到达网格的右下角（在下图中标记位"Finish"）。问总共有多少条不同的路径？
 *
 * 示例：
 * m = 3, n = 7  -> 28
 * m = 3, n = 2  -> 3
 * m = 7, n = 3  -> 28
 * m = 3, n = 3  -> 6
 */
public class UniquePaths {

    private static int solution(int m, int n) {
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    board[i][j] = 1;
                } else if (i == 0) {
                    board[i][j] = board[i][j - 1];
                } else if (j == 0) {
                    board[i][j] = board[i - 1][j];
                } else {
                    board[i][j] = board[i - 1][j] + board[i][j - 1];
                }
            }
        }
        return board[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 7));
        System.out.println(solution(3, 2));
        System.out.println(solution(7, 3));
        System.out.println(solution(3, 3));
    }


}
