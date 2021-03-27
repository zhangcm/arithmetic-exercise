package arithmetic.exercise.easy.list;

import arithmetic.exercise.common.ListNode;
import java.util.ArrayList;
import java.util.List;

public class PalindromeList {

    private static boolean solution(ListNode node) {
        if (node.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i).intValue() != list.get(j).intValue()) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 旋转一半，然后双指针比较
     */
    private static boolean solution2(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        int halfLength =  count / 2;
        int middleStart = (count % 2 == 0) ? (count / 2) : (count / 2 + 1);
        ListNode middleStartNode = head;
        for (int i = 0; i < middleStart; i++) {
            middleStartNode = middleStartNode.next;
        }
        node = head;
        ListNode reverseList = reverse(middleStartNode);
        for (int i = 0; i < halfLength; i++) {
            if (node.val != reverseList.val) {
                return false;
            }
            node = node.next;
            reverseList = reverseList.next;
        }
        return true;

    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode preNode = null;
        while (node.next != null) {
            ListNode next = node.next;
            node.next = preNode;
            preNode = node;
            node = next;
        }
        node.next = preNode;
        return node;
    }
}
