package arithmetic.exercise.list;

import arithmetic.exercise.common.ListNode;

/**
 * 876. Middle of the Linked List
 */
public class MiddleOfTheLinkedList {

    private static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null) {
            slow = slow.next;
            // 长度为偶数
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        for (int length = 1; length < 10; length++) {
            ListNode head = new ListNode(1);
            ListNode cur = head;
            for (int i = 1; i < length; i++) {
                cur.next = new ListNode(i + 1);
                cur = cur.next;
            }
            System.out.println(middleNode(head).val);
        }
    }
}
