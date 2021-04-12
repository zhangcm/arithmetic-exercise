package arithmetic.exercise.easy.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 *
 * 给定一个非负整数numRows，生成杨辉三角的前numRows行
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和
 */
public class YanghuiTriangle {

    private static List<List<Integer>> solution(int numRows) {
        List<List<Integer>> yanghuiTriangle = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                yanghuiTriangle.add(Collections.singletonList(1));
            } else {
                List<Integer> preRow = yanghuiTriangle.get(i - 2);
                List<Integer> item = new ArrayList<>();
                for (int j = 0; j < i - 1; j++) {
                    if (j == 0) {
                        item.add(preRow.get(j));
                    }
                    if (j + 1 == i - 1) {
                        item.add(preRow.get(j));
                    } else {
                        item.add(preRow.get(j) + preRow.get(j + 1));
                    }
                }
                yanghuiTriangle.add(item);
            }
        }
        return yanghuiTriangle;
    }

    /**
     * 补齐0
     *         0 1 0
     *       0 1 1 0
     *     0 1 2 1 0
     *   0 1 3 3 1 0
     * 0 1 4 6 4 1 0
     */
    private static List<List<Integer>> solution2(int numRows) {
        List<List<Integer>> yanghuiTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                yanghuiTriangle.add(Collections.singletonList(1));
            } else {
                List<Integer> preRow = yanghuiTriangle.get(i - 1);
                int length = preRow.size() + 2;
                List<Integer> fillRow = new ArrayList<>(length);
                fillRow.add(0);
                fillRow.addAll(preRow);
                fillRow.add(0);
                List<Integer> item = new ArrayList<>();
                for (int j = 0; j < length - 1; j++) {
                    item.add(fillRow.get(j) + fillRow.get(j + 1));
                }
                yanghuiTriangle.add(item);
            }
        }
        return yanghuiTriangle;
    }

    public static void main(String[] args) {
        System.out.println(solution2(5));
    }

}
