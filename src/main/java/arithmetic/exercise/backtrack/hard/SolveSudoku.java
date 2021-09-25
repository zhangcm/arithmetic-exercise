package arithmetic.exercise.backtrack.hard;

import arithmetic.exercise.common.ArrayUtils;
import arithmetic.exercise.common.ListUtils;

/**
 * 37 [hard]
 */
public class SolveSudoku {

    /**
     * 空格子为'.'
     */
    private static void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private static boolean backtrack(char[][] board, int x, int y) {
        if (x == 9) {
            return true;
        }
        if (y == 9) {
            return backtrack(board, x + 1, 0);
        }
        for (int i = 0; i < 9; i++) {
            if (board[x][y] != '.') {
                return backtrack(board, x, y + 1);
            }
            if (notValid(board, x, y, i)) {
                continue;
            }
            board[x][y] = (char) (i + '1');
            if (backtrack(board, x, y + 1)) {
                return true;
            }
            board[x][y] = '.';
        }
        return false;
    }

    private static boolean notValid(char[][] board, int x, int y, int num) {
        char target = (char) (num + '1');
        for (int i = 0; i < 9; i++) {
            if (i != y && board[x][i] == target) { // 行
                return true;
            }
            if (i != x && board[i][y] == target) { // 列
                return true;
            }
        }

        // 所在的小方格
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = (x / 3) * 3 + i;
                int col = (y / 3) * 3 + j;
                if (x != row && y != col && board[row][col] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    private static char[][] init() {
        return new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
    }

    public static void main(String[] args) {
        char[][] board = init();
        solveSudoku(board);
        ArrayUtils.println(board);
    }

}
