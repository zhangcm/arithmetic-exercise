package arithmetic.exercise.medium.backtrack;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.tuple.Pair;

/**
 * 单词搜索
 *
 * 给定一个m x n二维字符网格board和一个字符串单词word。如果word存在于网格中，返回true；否则，返回false。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中"相邻"单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class WordSearch {

    private static boolean solution(char[][] board, String word) {
        int width = board.length;
        for (int i = 0; i < width; i++) {
            char[] line = board[i];
            int length = line.length;
            for (int j = 0; j < length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    LinkedList<Pair<Integer, Integer>> tracked = new LinkedList<>();
                    tracked.add(Pair.of(i, j));
                    if (backtrack(board, tracked, 1, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, LinkedList<Pair<Integer, Integer>> tracked, int index, String word) {
        Pair<Integer, Integer> head = tracked.peek();
        int i = Objects.isNull(head) ? 0 : head.getLeft();
        int j = Objects.isNull(head) ? 0 : head.getRight();
        if (Objects.nonNull(head)) {
            if (board[head.getLeft()][head.getRight()] != word.charAt(index - 1)) {
                return false;
            }
            if (index == word.length()) {
                // 不能有重复元素
                return new LinkedHashSet<>(tracked).size() == tracked.size();
            }
        }
        List<Pair<Integer, Integer>> candidate = Arrays.asList(
            Pair.of(i - 1, j),
            Pair.of(i + 1, j),
            Pair.of(i, j - 1),
            Pair.of(i, j + 1));
        for (Pair<Integer, Integer> next : candidate) {
            if (next.getLeft() < 0 || next.getLeft() >= board.length
                || next.getRight() < 0 || next.getRight() >= board[0].length) {
                continue;
            }
            tracked.push(next);
            if (backtrack(board, tracked, index + 1, word)) {
                return true;
            }
            tracked.pop();
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        System.out.println(solution(board, word1));

        String word2 = "SEE";
        System.out.println(solution(board, word2));

        String word3 = "ABCB";
        System.out.println(solution(board, word3));
    }

}
