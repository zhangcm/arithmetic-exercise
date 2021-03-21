package arithmetic.exercise.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 有效数独
 */
public class ValidSodoku {

    private static boolean solution(char[][] nums) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (!Objects.equals(nums[i][j], '.')) {
                    if (!set.add(nums[i][j])) {
                        return false;
                    }
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            set.clear();
            for (int i = 0; i < 9; i++) {
                if (!Objects.equals(nums[i][j], '.')) {
                    if (!set.add(nums[i][j])) {
                        return false;
                    }
                }
            }
        }

        for (int k = 0; k < 9; k++) {
            set.clear();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3 ; j++) {
                    if (!Objects.equals(nums[i + (k / 3) * 3][j + (k % 3) * 3], '.')) {
                        if (!set.add(nums[i][j])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean solution2(char[][] board) {
        // 数据结构可优化，不用hashmap
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> lineMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());
            lineMap.put(i, new HashSet<>());
            boxMap.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!Objects.equals(board[i][j], '.')) {
                    if (!rowMap.get(i).add(board[i][j])
                        || !lineMap.get(j).add(board[i][j])
                        || !boxMap.get(i / 3 * 3 + j / 3).add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean solution3(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] lines = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!Objects.equals(board[i][j], '.')) {
                    int num = board[i][j] - '1';  // 转为1~9
                    if (rows[i][num] || lines[j][num] || boxes[i / 3 * 3 + j / 3][num]) {
                        return false;
                    } else {
                        rows[i][num] = true;
                        lines[j][num] = true;
                        boxes[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
        }
        return true;
    }

}
