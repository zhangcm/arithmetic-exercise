package arithmetic.exercise.list;

import arithmetic.exercise.common.ListNode;

/**
 * 141
 */
public class LinkedListCycle {

    /**
     * 快慢指针
     */
    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
