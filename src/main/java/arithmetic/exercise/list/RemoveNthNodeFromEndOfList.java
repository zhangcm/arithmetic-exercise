package arithmetic.exercise.list;

import arithmetic.exercise.common.ListNode;

/**
 * 19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int index = length - n;
        cur = dummy;
        int i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    /**
     * 假如长度为length，倒数第n个就是整数第length - n个，第一个指针先走n步，然后第一个第二个指针同时走，
     * 当第一个指针走到终点时，恰好走了length - n步。第二个指针也走了length - n步，执行删除。
     */
    private static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = dummy;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}
