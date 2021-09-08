package arithmetic.exercise.list;

import arithmetic.exercise.common.ListNode;

/**
 * 21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {

    /**
     * 虚拟头结点，简化处理
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            cur.next = l1.val <= l2.val ? l1 : l2;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}
