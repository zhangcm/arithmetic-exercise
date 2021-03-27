package arithmetic.exercise.easy.list;

import arithmetic.exercise.common.ListNode;

public class DeleteNode {

    private static void solution(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
