package arithmetic.exercise.medium.list;

import static arithmetic.exercise.common.ListNodeUtils.build;
import static arithmetic.exercise.common.ListNodeUtils.println;


import arithmetic.exercise.common.ListNode;
import arithmetic.exercise.common.ListNodeUtils;
import java.util.ArrayList;
import java.util.List;

public class TwoListSum {

    private static ListNode solution(ListNode n1, ListNode n2) {
        ListNode sum = new ListNode(0);
        ListNode cur = sum;
        boolean carryFlag = false;
        while (n1 != null || n2 != null) {
            int num1 = 0;
            int num2 = 0;
            if (n1 != null) {
                num1 = n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                num2 = n2.val;
                n2 = n2.next;
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
        ListNode n1 = build(new int[] {2, 4, 3});
        ListNode n2 = build(new int[] {5, 6, 4});

        ListNode result = solution(n1, n2);
        println(result);

        n1 = build(new int[] {0});
        n2 = build(new int[] {0});

        result = solution(n1, n2);
        println(result);

        n1 = build(new int[] {9, 9, 9, 9, 9, 9, 9});
        n2 = build(new int[] {9, 9, 9, 9});

        result = solution(n1, n2);
        println(result);

    }



}
