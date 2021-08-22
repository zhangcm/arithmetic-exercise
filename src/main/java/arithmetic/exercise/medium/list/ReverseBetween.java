package arithmetic.exercise.medium.list;

import arithmetic.exercise.common.ListNode;
import arithmetic.exercise.common.ListNodeUtils;

/**
 * 92. Reverse Linked List II
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Example
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class ReverseBetween {

    private static ListNode solution(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode reverseHead = null;
        ListNode subListHead = null;
        ListNode subListTail = null;

        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode cur = tempHead;
        ListNode next;
        int index = 0;
        while (cur != null) {
            next = cur.next;
            if (index == left - 1) {
                reverseHead = cur;
            } else if (index == left) {
                subListHead = cur;
                subListTail = cur;
            } else if (index > left && index <= right) {
                subListHead.next = next;
                cur.next = subListTail;
                subListTail = cur;
            }
            cur = next;
            index++;
        }
        reverseHead.next = subListTail;
        return tempHead.next;
    }


    public static void main(String[] args) {
        ListNode node = ListNodeUtils.build(new int[] {1, 2, 3, 4, 5, 6, 7, 8, });
        solution(node, 2, 4);
        ListNodeUtils.println(node);
    }
}
