package arithmetic.exercise.medium.list;

import static arithmetic.exercise.common.ListNodeUtils.build;
import static arithmetic.exercise.common.ListNodeUtils.println;


import arithmetic.exercise.common.ListNode;

public class OddEvenList {

    private static ListNode solution(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddEnd = head;
        ListNode evenBegin = head.next;
        ListNode evenEnd = head.next;
        ListNode cur = head.next;
        // 从第一个偶数开始
        while (cur != null) {
            cur = cur.next;
            if (cur != null) {
                ListNode next = cur.next;
                evenEnd.next = cur.next;
                evenEnd = evenEnd.next;
                cur.next = evenBegin;
                oddEnd.next = cur;
                oddEnd = oddEnd.next;
                cur = next;
            }
        }
        return head;
    }

    /**
     * 先分离出奇偶链表，再将偶数节点链表的头部追加到奇数节点链表的尾部
     */
    private static ListNode solution2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;  // 偶数链表
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        println(solution2(build(new int[] {1, 2, 3, 4, 5, 6, 7, 8})));  // 1 3 5 7 2 4 6 8
        println(solution2(build(new int[] {1, 2, 3, 4, 5})));  // 1 3 5 2 4
        println(solution2(build(new int[] {2, 1, 3, 5, 6, 4, 7})));  // 2 3 6 7 1 5 4
    }

}
