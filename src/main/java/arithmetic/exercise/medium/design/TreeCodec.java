package arithmetic.exercise.medium.design;

import arithmetic.exercise.common.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TreeCodec {

    private String serialize(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode none = new TreeNode(-1);
        stack.push(root);
        TreeNode current = null;
        List<String> data = new ArrayList<>();
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current == none) {
                data.add("null");
                continue;
            } else {
                data.add(current.val + "");
            }
            if (current.right == null) {
                stack.push(none);
            } else {
                stack.push(current.right);
            }
            if (current.left == null) {
                stack.push(none);
            } else {
                stack.push(current.left);
            }
        }
        return String.join(",", data);
    }

    private String serialize1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode none = new TreeNode(0);
        doSerialize1(root, list, none);
        return list.stream().map(node -> node == none ? "null" : (node.val + "")).collect(Collectors.joining(","));
    }

    private void doSerialize1(TreeNode root, List<TreeNode> list, TreeNode none) {
        if (root == null) {
            list.add(none);
            return;
        }
        list.add(root);
        doSerialize1(root.left, list, none);
        doSerialize1(root.right, list, none);
    }

    private TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
        return doDeserialize(list);
    }

    private TreeNode doDeserialize(List<String> list) {
        String data = list.get(0);
        if (Objects.equals(data, "null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data));
        list.remove(0);
        root.left = doDeserialize(list);
        root.right = doDeserialize(list);
        return root;
    }
}
