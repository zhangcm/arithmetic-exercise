package arithmetic.exercise.list;

import arithmetic.exercise.common.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 */
public class MergeKSortedLists {

    /**
     * PriorityQueue
     */
    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int length = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(length, Comparator.comparing(ListNode::getVal));
        for (int i = 0; i < length; i++) {
            queue.add(lists[i]);
        }
        ListNode min;
        while (!queue.isEmpty()) {
            min = queue.poll();
            if (min != null) {
                cur.next = min;
                cur = cur.next;
                queue.add(min.next);
            }
        }
        return dummy.next;
    }

    private static ListNode mergeKLists1(ListNode[] lists) {
        int length = lists.length;
        ListNode cur = lists[0];
        for (int i = 1; i < length; i++) {
            cur = MergeTwoSortedLists.mergeTwoLists(cur, lists[i]);
        }
        return cur;
    }

}
