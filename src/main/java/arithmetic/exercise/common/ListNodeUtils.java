package arithmetic.exercise.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ListNodeUtils {

    private ListNodeUtils() {
        throw new UnsupportedOperationException();
    }

    public static ListNode build(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        if (nums.length == 1) {
            return head;
        }
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void println(ListNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        System.out.println(list.toString());
    }

}
