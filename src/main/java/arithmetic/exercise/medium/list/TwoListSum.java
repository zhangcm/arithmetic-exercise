package arithmetic.exercise.medium.list;

import static arithmetic.exercise.common.ListNodeUtils.build;
import static arithmetic.exercise.common.ListNodeUtils.println;


import arithmetic.exercise.common.ListNode;

public class TwoListSum {

    private static ListNode solution(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode cur = sum;
        boolean carryFlag = false;
        while (l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int result = num1 + num2 + (carryFlag ? 1 : 0) ;
            if (result >= 10) {
                cur.next = new ListNode(result % 10);
                carryFlag = true;
            } else {
                cur.next = new ListNode(result);
                carryFlag = false;
            }
            cur = cur.next;
        }
        if (carryFlag) {
            cur.next = new ListNode(1);
        }
        return sum.next;
    }

    public static void main(String[] args) {
        println(solution(build(new int[] {2, 4, 3}), build(new int[] {5, 6, 4})));
        println(solution(build(new int[] {0}), build(new int[] {0})));
        println(solution(build(new int[] {9, 9, 9, 9, 9, 9, 9}), build(new int[] {9, 9, 9, 9})));
    }



}
