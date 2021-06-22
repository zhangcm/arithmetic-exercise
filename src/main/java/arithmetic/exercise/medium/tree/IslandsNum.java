package arithmetic.exercise.medium.tree;

/**
 * 给你一个由'1'(陆地)和'0'(水)组成的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边被水包围
 * 例：
 * ['1', '1', '1', '1', '0']
 * ['1', '1', '0', '1', '0']
 * ['1', '1', '0', '0', '0']
 * ['0', '0', '0', '0', '0']
 * 岛屿数量：1
 *
 * ['1', '1', '0', '1', '0']
 * ['1', '1', '0', '0', '0']
 * ['0', '0', '0', '1', '0']
 * ['0', '0', '0', '1', '1']
 * 岛屿数量：3
 */
public class IslandsNum {

    /**
     * 从上往下遍历，
     * 找到一个为'1'的点，递归遍历其左右下三个节点，找到所有为'1'的点并置为'0'，
     * 相邻的所有节点改为'0'后，岛屿遍历完成，岛屿数量加1
     */
    private static int solution(char[][] grid) {
        int islandsNum = 0;
        int width = grid.length;
        int length = grid[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, length, width);
                    islandsNum++;
                }
            }
        }
        return islandsNum;
    }

    private static void dfs(char[][] grid, int x, int y, int length, int width) {
        if (x >= width || y < 0 || y >= length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x, y - 1, length, width);
        dfs(grid, x, y + 1, length, width);
        dfs(grid, x + 1, y, length, width);
    }

    public static void main(String[] args) {
        char[][] grid1 = new char[][] {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution(grid1));  // 1

        char[][] grid2 = new char[][] {
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '1', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution(grid2));  // 3
    }

}
