package arithmetic.exercise.medium.list;

import arithmetic.exercise.common.ListNode;
import arithmetic.exercise.common.ListNodeUtils;
import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 *   4 1 8 4 5
 * 5 0 1 8 4 5
 * 相交节点1
 */
public class GetIntersectionNode {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static ListNode solution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<Integer> valSet = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            valSet.add(node.val);
            node = node.next;
        }
        node = headB;
        ListNode intersectionNode = null;
        boolean hasIntersection = false;
        while (node != null) {
            if (valSet.contains(node.val)) {
                if (!hasIntersection) {
                    hasIntersection = true;
                    intersectionNode = node;
                }
            } else if (hasIntersection) {
                hasIntersection = false;
                intersectionNode = null;
            }
            node = node.next;
        }
        return intersectionNode;
    }

    /**
     * 如果有交点，必然是一个Y字形的。先计算出两个链表的长度差n，长度较长的那个链表的前n个节点必定不会与短链表相交，可以先跳过。
     * 之后双指针同步遍历，如果val相同，则有交点
     */
    private static ListNode solution2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int headALen = 0;
        int headBLen = 0;

        ListNode nodeA = headA;
        while (nodeA != null) {
            headALen++;
            nodeA = nodeA.next;
        }
        ListNode nodeB = headB;
        while (nodeB != null) {
            headBLen++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;

        int len = Math.abs(headALen - headBLen);
        if (headALen > headBLen) {
            while (len >= 0) {
                nodeA = nodeA.next;
                len--;
            }
        } else if (headALen < headBLen) {
            while (len > 0) {
                nodeB = nodeB.next;
                len--;
            }
        }
        while (nodeA != null && nodeB != null) {
            if (nodeA.val == nodeB.val) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = ListNodeUtils.build(new int[] {4, 1, 8, 4, 5});
        ListNode headB = ListNodeUtils.build(new int[] {5, 0, 1, 8, 4, 5});
        ListNodeUtils.println(solution2(headA, headB));
        ListNodeUtils.println(solution(headA, headB));
    }
}
