package arithmetic.exercise.easy.list;

import arithmetic.exercise.common.ListNode;
import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {

    private static ListNode solution(ListNode head, int n) {
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        if (n == 1) {
            list.get(list.size() - 2).next = null;
        }
        ListNode target = list.get(list.size() - n);
        target.val = target.next.val;
        target.next = target.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode reverse = solution(head, 2);
        System.out.println(reverse);
    }

}
