package arithmetic.exercise.list;

import arithmetic.exercise.common.ListNode;

/**
 * 142.
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
public class LinkedListCycleII {

    /**
     * 慢指针走了k步，与快指针相遇，快指针走了2k步，且k是圆周长的整数倍。
     * 假设起点到圆环起点的距离是m步，则圆环起点到快慢指针相遇点是k-m步。
     * 慢指针再走m步，刚好是k，k是圆周长的整数倍，慢指针就刚好到了圆环起点。
     * 在慢指针开始走的时候，第三个指针从起点开始走，走到圆环起点也刚好是m步。
     * 所以这俩指针的交点就是圆环起点。
     */
    private static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
}
