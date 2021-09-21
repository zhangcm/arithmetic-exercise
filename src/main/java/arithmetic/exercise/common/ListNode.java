package arithmetic.exercise.common;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }
}
