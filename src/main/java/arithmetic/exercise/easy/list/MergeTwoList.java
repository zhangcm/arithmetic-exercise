package arithmetic.exercise.easy.list;

import arithmetic.exercise.common.ListNode;
import java.util.Objects;

public class MergeTwoList {

    private static ListNode solution(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1) || Objects.isNull(l2)) {
            return Objects.isNull(l1) ? l2 : l1;
        }
        ListNode mergeHead = l1.val <= l2.val ? l1 : l2;
        ListNode low = l1.val <= l2.val ? l1 : l2;
        ListNode high = l1.val <= l2.val ? l2 : l1;

        while (low != null || high != null) {
            if (low.next == null) {
                low.next = high;
                break;
            } else {
                if (low.next.val > high.val) {
                    ListNode highNext = high.next;
                    ListNode lowNext = low.next;
                    low.next = high;
                    high.next = lowNext;
                    high = highNext;
                    low = lowNext;
                } else {
                    low = low.next;
                }
            }
        }
        return mergeHead;
    }

    private static ListNode solution2(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1) || Objects.isNull(l2)) {
            return Objects.isNull(l1) ? l2 : l1;
        }
        ListNode mergeHead = l1.val <= l2.val ? l1 : l2;
        ListNode mergeList = null;
        while (l1 != null || l2 != null) {
            ListNode current;
            if (l1 != null) {
                if (l2 == null) {
                    current = l1;
                    l1 = l1.next;
                } else if (l1.val <= l2.val) {
                    current = l1;
                    l1 = l1.next;
                } else {
                    current = l2;
                    l2 = l2.next;
                }
            } else {
                current = l2;
                l2 = l2.next;
            }
            if (mergeList != null) {
                mergeList.next = current;
                mergeList = mergeList.next;
            } else {
                mergeList = current;
                mergeHead = current;
            }
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(15);
        head1.next = node11;
        node11.next = node12;

        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        head2.next = node21;
        node21.next = node22;

        ListNode mergeList = solution2(head1, head2);
        System.out.println(mergeList);
    }

}
