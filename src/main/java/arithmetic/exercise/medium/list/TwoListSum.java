package arithmetic.exercise.medium.list;

import arithmetic.exercise.common.ListNode;
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
        print(result);

        n1 = build(new int[] {0});
        n2 = build(new int[] {0});

        result = solution(n1, n2);
        print(result);

        n1 = build(new int[] {9, 9, 9, 9, 9, 9, 9});
        n2 = build(new int[] {9, 9, 9, 9});

        result = solution(n1, n2);
        print(result);

    }

    private static ListNode build(int[] nums) {
        ListNode node = new ListNode(nums[0]);
        ListNode cur = node;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return node;
    }

    private static void print(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        System.out.println(list.toString());
    }

}
