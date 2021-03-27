package arithmetic.exercise.easy.list;

import arithmetic.exercise.common.ListNode;

public class HasCycle {

    private static boolean solution(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        while (first != second) {
            first = first.next;
            if (first == null) {
                return false;
            }
            second = second.next;
            if (second == null) {
                return false;
            }
            second = second.next;
            if (second == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(15);
        ListNode node13 = new ListNode(17);
        head.next = node11;
        node11.next = node12;
        node12.next = node13;
        // node13.next = node11;
        System.out.println(solution(head));
    }

}
