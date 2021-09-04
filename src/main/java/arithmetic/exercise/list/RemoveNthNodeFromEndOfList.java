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
        if (index == 0) {
            dummy.next = head.next;
        }
        cur = head;
        int i = 0;
        while (cur != null) {
            if (i == index - 1) {
                cur.next = cur.next.next;
                break;
            } else {
                cur = cur.next;
            }
            i++;
        }
        return dummy.next;
    }
}
