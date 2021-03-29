package arithmetic.exercise.easy.dp;

public class ClimbStairs {

    public static int solution(int n) {
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }

    public static int solution2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return solution2(n - 1) + solution2(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution2(5));
    }

}
