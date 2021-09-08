package arithmetic.exercise.list;

import arithmetic.exercise.common.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked Lists [easy]
 */
public class IntersectionOfTwoLinkedList {

    /**
     * 将A接在B上，将B接在A，如果有交点且长度不同，最终会在第二次到交点时相遇
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            if (nodeA == null) {
                nodeA = headB;
            }
            nodeB = nodeB.next;
            if (nodeB == null) {
                nodeB = headA;
            }
        }
        return null;
    }

    /**
     * 如果有交点，必然是一个Y字形的。先计算出两个链表的长度差n，长度较长的那个链表的前n个节点必定不会与短链表相交，可以先跳过。
     * 之后双指针同步遍历，如果val相同，则有交点
     */
    private static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int headALength = 0;
        int heabBLength = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null || nodeB != null) {
            if (nodeA != null) {
                headALength++;
                nodeA = nodeA.next;
            }
            if (nodeB != null) {
                heabBLength++;
                nodeB = nodeB.next;
            }
        }
        // nodeA指向长度较长的链表，先走nodeA，再匹配
        if (headALength < heabBLength) {
            nodeA = headB;
            nodeB = headA;
        }
        int skip = Math.abs(headALength - heabBLength);
        int index = 0;
        while (index < skip) {
            nodeA = nodeA.next;
            index++;
        }
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    /**
     * 找个集合先存起来，空间复杂度过高
     */
    private static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            nodeSet.add(node);
            node = node.next;
        }
        node = headB;
        ListNode intersectionNode = null;
        while (node != null) {
            if (nodeSet.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return intersectionNode;
    }
}
