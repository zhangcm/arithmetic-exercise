package arithmetic.exercise.list;

import arithmetic.exercise.common.ListNode;

/**
 * 206 [easy]
 */
public class ReverseList {

    private static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        return recur(head, next);
    }

    private static ListNode recur(ListNode preNode, ListNode node) {
        if (node.next == null) {
            node.next = preNode;
            return node;
        }

        ListNode next = node.next;
        node.next = preNode;
        return recur(node, next);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverse = solution(node1);
        System.out.println(reverse);
    }

}
