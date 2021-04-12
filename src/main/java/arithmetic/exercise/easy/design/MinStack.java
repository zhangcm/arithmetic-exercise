package arithmetic.exercise.easy.design;

import java.util.Arrays;

public class MinStack {

    private int[] origin;
    private int size = 0;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        origin = new int[8];
    }

    public void push(int x) {
        if (size == origin.length) {
            int[] newArr = new int[origin.length * 2];
            System.arraycopy(origin, 0, newArr, 0, origin.length);
            origin = newArr;
        }
        origin[size] = x;
        if (x < min) {
            min = x;
        }
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        size--;
        int num = origin[size];
        origin[size] = 0;
        if (size == 0) {
            min = Integer.MAX_VALUE;
        } else if (num == min) {
            int[] sortArr = new int[size];
            System.arraycopy(origin, 0, sortArr, 0, size);
            Arrays.sort(sortArr);
            min = sortArr[0];
        }
        return num;
    }

    public int getMin() {
        return size == 0 ? 0 : min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(7);
        System.out.println(stack.getMin());
        stack.push(5);
        System.out.println(stack.getMin());
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(9);
        System.out.println(stack.getMin());
        stack.push(11);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());

    }

}
