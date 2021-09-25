package arithmetic.exercise.todo.dp;

/**
 * 354. Russian Doll Envelopes [hard]
 *
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width
 * and the height of an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope are greater
 * than the other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 *
 * envelopes = [[5,4],[6,4],[6,7],[2,3]] => 3 ([2,3] => [5,4] => [6,7])
 *
 */
public class RussianDollEnvelopes {

    /**
     * 先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序。之后把所有的 h 作为一个数组，
     * 在这个数组上计算 LIS 的长度就是答案。
     */
    private static int maxEnvelopes(int[][] envelopes) {
        return 0;
    }
}
