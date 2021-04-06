package arithmetic.exercise.easy.math;

/**
 * 给定一个整数，写一个函数来判断它是否是3的幂次方。如果是，返回true；否则返回false
 */
public class PowerOfThree {

    private static boolean solution(int n) {
        int current = 3;
        if (current == n) {
            return true;
        }
        while (current < n) {
            current = current * 3;
            if (current == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(27));
        System.out.println(solution(0));
        System.out.println(solution(9));
        System.out.println(solution(45));
    }

}
