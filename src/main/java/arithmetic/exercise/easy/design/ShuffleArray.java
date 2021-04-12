package arithmetic.exercise.easy.design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    private final int[] origin;
    private final int[] shuffleArr;

    private final Random random = new Random();

    public ShuffleArray(int[] nums) {
        this.origin = nums;
        this.shuffleArr = new int[nums.length];
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        System.arraycopy(origin, 0, shuffleArr, 0, origin.length);
        for (int i = origin.length; i > 0; i--) {
            int randomIndex = random.nextInt(i);
            int temp = shuffleArr[i - 1];
            shuffleArr[i - 1] = shuffleArr[randomIndex];
            shuffleArr[randomIndex] = temp;
        }
        return shuffleArr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ShuffleArray solution = new ShuffleArray(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

}
