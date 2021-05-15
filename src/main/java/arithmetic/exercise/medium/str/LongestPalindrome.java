package arithmetic.exercise.medium.str;

/**
 * 最长回文字串
 */
public class LongestPalindrome {

    /**
     * 从大往小不好处理，因为不知道回文串在哪里，指针不好移动
     * 从小往大处理，先找到回文串的起点
     *
     * abeeeee与abeeee这种不好处理
     */
    private static String solution(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        String max = String.valueOf(s.charAt(0));
        StringBuilder strb = new StringBuilder("#");
        for (int i = 0; i < length; i++) {
            strb.append(Character.toLowerCase(s.charAt(i))).append('#');
        }
        String temp = strb.toString();
        length = temp.length();
        int maxLength = 1;
        for (int i = 1; i < length - 1; i++) {
            int j = i - 1;
            int k = i + 1;
            while (temp.charAt(j) == temp.charAt(k)) {
                j--;
                k++;
                if (j < 0 || k >= length) {
                    break;
                }
            }
            String substring = temp.substring(j == 0 ? 0 : j + 1, k);
            if (substring.length() > maxLength) {
                maxLength = substring.length();
                max = substring;
            }
        }
        return max.replace("#", "");
    }

    /**
     * 动态规划
     *
     * 状态转移方程：
     * P(i, j) = P(i + 1, j - 1) ^ (Si == Sj)
     * 也就是说：只有s[i + 1, j - 1]是回文串，并且s的第i个和j个字母相同时，s[i, j]才会是回文串
     * 边界条件是子串的长度为1或2.
     * P(i, i) = true   P(i, i + 1) = (Si == Si+1)
     */
    private static String solution2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示s[i, j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArr = s.toCharArray();
        // 递推开始
        // 先枚举"子串"长度，子串长度为1的都是true，上面已经已经初始过了，所以从2开始，直到整个字符串
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由子串长度L和i可以确定右边界, 即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArr[i] != charArr[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][L] == true成立，就表示子串 s[i..L]是回文，此时记录回文串长度和起始位置
                if (dp[i][j] && (j - i + 1 > maxLen)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static String solution3(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLength = 1;
        int start = 0;

        for (int subLen = 2; subLen <= len; subLen++) {
            for (int i = 0; i < len; i++) {
                int j = subLen + i - 1;
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else if (j - i < 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && subLen > maxLength) {
                    maxLength = subLen;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    private static String solution4(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right <= 0 && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left + 1;
    }

    /**
     * manacher算法
     * 对中心扩展算法的优化。定义了一个臂长的数组，利用这个臂长数组简化一些回文子串的求取过程，将时间复杂度降低到O(n)
     *
     * 1. 填充
     * 中心扩展算法存在一个问题，就是对偶数长度回文串的求解。
     * 比如 aba 以b点为中心扩展，可以求出回文串。但是abba以哪个b点为中心进行扩展都无法求出，只能以两个b之间的空白为中心去扩展才行。
     * 基于这个，使用填充字符，将偶数转为奇数来求解。比如aba填充为#a#b#a#，abba填充为#a#b#b#a#，这样无论奇数、偶数，最终都是奇数，就可以使用中心扩展方法了。
     *
     * 2. 臂长。臂长是从回文子串中心点到左边界或右边界的长度。
     * 比如aba的臂长为2，abcba的臂长是3。
     *
     * 3. 臂长数组
     * 对目标字符串的每一个字符求臂长，得到的数组就是臂长数组。
     * 以#a#b#a#为例。
     * 第一个字符#的回文串是#，臂长为1。
     * 第二个字符a的回文串是#a#，臂长为2。
     * 第三个字符#的回文串是#，臂长为1。
     * 第四个字符b的回文串是#a#b#a#，臂长为4。
     * 依次类推...
     * 所以臂长数组为[1, 2, 1, 4, 1, 2, 1]
     *
     * 从上面可以看出，最长回文子串就是以臂长数组中臂长最大的那个位置为中心点的子串。
     *
     * 所以只要求解出臂长数组即可。同时臂长数组前面的值也会简化后续回文串的臂长的求解问题。
     *
     * 4. 求解臂长数组
     * -----------------------------
     *       L     j    C    i     R
     * 求解过程中有这么几个坐标点：
     * R是已遍历过的字符中回文子串的最右边界
     * C是最右边界为R的回文子串的中心点
     * L是R关于C的对称点
     * i是当前要求解的点
     * j是i关于C的对称点，j的坐标等于 C - (i - C)，即 2C -i
     *
     * 初始时，i = 0, R = -1，i在R的右边。随着R的不断更新，i可能在R的左边。所以需要分两种情况
     *
     * 1）i在R的右边，以i为中心，扩展求回文子串。
     * 2）i在R的左边，那这时i必定在C与R之间，找到i关于C的对称点j。从臂长数组中可以得到j的臂长。
     * 根据j的臂长可以算出以j为中心的回文串的左边界jl。
     * jl的落点有三种情况：
     *   2.1）jl在L右侧，i的臂长为等于j的臂长
     *   2.2）jl在L的左侧，i的臂长 = R - i + 1
     *   2.3) jl在L，则i的臂长从R点开始继续往右侧扩
     *
     */
    private static String solution5(String s) {
        StringBuilder strb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            strb.append(Character.toLowerCase(s.charAt(i))).append('#');
        }
        String palindrome = manacher2(strb.toString());
        return palindrome.replace("#", "");
    }

    private static String manacher1(String s) {
        int start = 0;
        int max = 1;
        // 臂长数组
        int[] armLen = new int[s.length()];
        armLen[0] = 1;
        int r = -1;
        int c = -1;
        int base;
        for (int i = 1; i < s.length(); i++) {
            if (r > i) {
                int j = c * 2 - i;  // i的对称点坐标
                int l = c * 2 - r;
                int jl = j - armLen[j] + 1;
                if (l < jl) {  // 落在右侧
                    armLen[i] = armLen[j];
                    continue;
                } else if (l > jl) {
                    armLen[i] = r - i + 1;
                    continue;
                } else {
                    base = armLen[j];
                }
            } else {
                base = 1;
            }
            int curArmLen = expand(s, i - base, i + base);
            armLen[i] = curArmLen;
            if (curArmLen > max) {
                max = curArmLen;
                start = i - curArmLen + 1;
            }
            if (i + curArmLen - 1 > r) {
                r = i + curArmLen - 1;
                c = i;
            }
        }
        return s.substring(start, start + max * 2 - 1);
    }

    private static String manacher2(String s) {
        int start = 0;
        int max = 1;
        // 臂长数组
        int[] armLen = new int[s.length()];
        int r = -1;
        int c = -1;
        int base;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            armLen[i] = r > i ? Math.min(armLen[c * 2 - i], r - i + 1) : 1;
            while (i - armLen[i] > -1 && i + armLen[i] < length) {
                if (s.charAt(i - armLen[i]) == s.charAt(i + armLen[i])) {
                    armLen[i]++;
                } else {
                    break;
                }
            }
            if (i + armLen[i] > r) {
                r = i + armLen[i] - 1;
                c = i;
            }
            if (armLen[i] > max) {
                max = armLen[i];
                start = i - armLen[i] + 1;
            }
        }
        return s.substring(start, start + max * 2 - 1);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return (right - left) / 2;
    }




    public static void main(String[] args) {
        System.out.println(solution5("abceeee"));
        System.out.println(solution5("abceeeee"));
    }

}