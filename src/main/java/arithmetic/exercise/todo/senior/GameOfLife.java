package arithmetic.exercise.todo.senior;

/**
 * 生命游戏
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised
 * by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or
 * dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the
 * following four rules (taken from the above Wikipedia article):
 *
 * 1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * 2. Any live cell with two or three live neighbors lives on to the next generation.
 * 3. Any live cell with more than three live neighbors dies, as if by over-population.
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 * Example:
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 *
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 * Constraints:
 *
 * · m == board.length
 * · n == board[i].length
 * · 1 <= m, n <= 25
 * · board[i][j] is 0 or 1.
 *
 * Follow up:
 *
 * 1. Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells
 * first and then use their updated values to update other cells.
 * 2. In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches upon the border of the array (i.e., live cells
 * reach the border). How would you address these problems?
 *
 */
public class GameOfLife {

    private static int liveNeighbors(int[][] board, int i, int j, int width, int length) {
        int result = 0;
        for (int m = -1; m <= 1; m++) {
            for (int n = -1; n <= 1; n++) {
                if (m == 0 && n == 0) {
                    continue;
                }
                int x = i + m;
                int y = j + n;
                if (x < 0 || y < 0 || x >= length || y >= width) {
                    continue;
                }
                result += (board[x][y] % 2);
            }
        }
        return result;
    }

    private static int[][] solution(int[][] board) {
        int width = board.length;
        int length = board[0].length;
        int[][] result = new int[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                int liveNeighbors = liveNeighbors(board, i, j, length, width);
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    result[i][j] = 1;
                } else if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        result[i][j] = 0;
                    } else {
                        result[i][j] = 1;
                    }
                }
            }
        }
        return result;
    }

    private static int[][] solution1(int[][] board) {
        int width = board.length;
        int length = board[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                int liveNeighbors = liveNeighbors(board, i, j, length, width);
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 3;
                    }
                } else if (liveNeighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        solution1(new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}});  // [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        solution1(new int[][] {{1, 1}, {1, 0}});  // [[1,1],[1,1]]
    }
}
