package arithmetic.exercise.todo.dp;

/**
 * 72. Edit Distance [hard]
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * · Insert a character
 * · Delete a character
 * · Replace a character
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
public class EditDistance {

    /**
     * TODO run
     */
    private static int minDistance(String word1, String word2) {
        int width = word1.length();
        int length = word2.length();
        int[][] dpTable = new int[width + 1][length + 1];
        for (int i = 0; i <= width; i++) {
            dpTable[i][0] = i;
        }
        for (int j = 0; j <= length; j++) {
            dpTable[0][j] = j;
        }
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dpTable[i][j] = dpTable[i - 1][j - 1];
                } else {
                    dpTable[i][j] = Math.min(dpTable[i - 1][j - 1], Math.min(dpTable[i][j - 1], dpTable[i - 1][j])) + 1;
                }
            }
        }
        return dpTable[width][length];
    }

    private static int minDistance1(String word1, String word2) {
        int[][] dpTable = new int[word1.length()][word2.length()];
        return dp(word1, word2, word1.length() - 1, word2.length() - 1, dpTable);
    }

    private static int dp(String word1, String word2, int i, int j, int[][] dpTable) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            dpTable[i][j] = dp(word1, word2, i - 1, j - 1, dpTable);
        } else {
            dpTable[i][j] = Math.min(dp(word1, word2, i - 1, j - 1, dpTable),
                Math.min(dp(word1, word2, i, j - 1, dpTable), dp(word1, word2, i - 1, j, dpTable))) + 1;
        }
        return dpTable[i][j];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));            // 3
        System.out.println(minDistance("intention", "execution"));  // 5
    }

}
