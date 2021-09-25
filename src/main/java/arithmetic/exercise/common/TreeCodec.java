package arithmetic.exercise.common;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class TreeCodec {

    private static final String SEP = ",";
    private static final String NULL = "#";

    public static String preSerialize(TreeNode root) {
        StringBuilder strb = new StringBuilder();
        doPreSerialize(root, strb);
        return strb.deleteCharAt(strb.length() - 1).toString();
    }

    private static void doPreSerialize(TreeNode root, StringBuilder strb) {
        if (root == null) {
            strb.append(NULL).append(SEP);
            return;
        }
        strb.append(root.val).append(SEP);
        doPreSerialize(root.left, strb);
        doPreSerialize(root.right, strb);
    }

    public static TreeNode preDeserialize(String str) {
        String[] arr = str.split(SEP);
        if (arr.length == 1) {
            return null;
        }
        Deque<String> nodes = new LinkedList<>();
        for (String s : arr) {
            nodes.add(s);
        }
        return doPreDeserialize(nodes);
    }

    private static TreeNode doPreDeserialize(Deque<String> nodes) {
        String node = nodes.poll();
        if (Objects.equals(node, NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = doPreDeserialize(nodes);
        root.right = doPreDeserialize(nodes);
        return root;
    }

    public static String postSerialize(TreeNode root) {
        StringBuilder strb = new StringBuilder();
        doPostSerialize(root, strb);
        return strb.deleteCharAt(strb.length() - 1).toString();
    }

    private static void doPostSerialize(TreeNode root, StringBuilder strb) {
        if (root == null) {
            strb.append(NULL).append(SEP);
            return;
        }
        doPostSerialize(root.left, strb);
        doPostSerialize(root.right, strb);
        strb.append(root.val).append(SEP);
    }

    public static TreeNode postDeserialize(String str) {
        String[] arr = str.split(SEP);
        if (arr.length == 1) {
            return null;
        }
        Deque<String> nodes = new LinkedList<>();
        for (String s : arr) {
            nodes.addFirst(s);
        }
        return doPostDeserialize(nodes);
    }

    private static TreeNode doPostDeserialize(Deque<String> nodes) {
        String node = nodes.poll();
        if (Objects.equals(node, NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.right = doPostDeserialize(nodes);
        root.left = doPostDeserialize(nodes);
        return root;
    }

    public static String levelSerialize(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        TreeNode nullNode = new TreeNode(-1);
        StringBuilder strb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == nullNode) {
                strb.append(NULL).append(SEP);
                continue;
            }
            strb.append(cur.val).append(SEP);
            queue.add(cur.left == null ? nullNode : cur.left);
            queue.add(cur.right == null ? nullNode : cur.right);
        }
        return strb.deleteCharAt(strb.length() - 1).toString();
    }

    public static TreeNode levelDeserialize(String str) {
        String[] arr = str.split(SEP);
        if (arr.length == 1) {
            return null;
        }
        Deque<String> nodes = new LinkedList<>();
        for (String s : arr) {
            nodes.add(s);
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode parent;
        String temp;
        while (!nodes.isEmpty()) {
            parent = queue.poll();
            temp = nodes.poll();
            if (!Objects.equals(temp, NULL)) {
                parent.left = new TreeNode(Integer.parseInt(temp));
                queue.add(parent.left);
            }
            temp = nodes.poll();
            if (!Objects.equals(temp, NULL)) {
                parent.right = new TreeNode(Integer.parseInt(temp));
                queue.add(parent.right);
            }
        }
        return root;
    }

}
