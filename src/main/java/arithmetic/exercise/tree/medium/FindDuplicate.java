package arithmetic.exercise.tree.medium;

import arithmetic.exercise.common.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 652
 */
public class FindDuplicate {

    private static List<TreeNode> findDuplicate(TreeNode root) {
        List<TreeNode> subTrees = new ArrayList<>();
        List<TreeNode> duplicateTrees = new ArrayList<>();
        doFindDuplicate(root, subTrees, duplicateTrees);
        return duplicateTrees;
    }

    private static void doFindDuplicate(TreeNode root, List<TreeNode> subTrees, List<TreeNode> duplicateTrees) {
        if (root == null) {
            return;
        }
        boolean exist = false;
        for (TreeNode node : subTrees) {
            if (equal(node, root)) {
                duplicateTrees.add(node);
                exist = true;
            }
        }
        if (!exist) {
            subTrees.add(root);
        }
        doFindDuplicate(root.left, subTrees, duplicateTrees);
        doFindDuplicate(root.right, subTrees, duplicateTrees);
    }

    private static boolean equal(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null || n1.val != n2.val) {
            return false;
        }
        return equal(n1.left, n2.left) && equal(n1.right, n2.right);
    }

    private static List<TreeNode> findDuplicate1(TreeNode root) {
        HashMap<String, Integer> visitedTrees = new HashMap<>();
        List<TreeNode> duplicateTrees = new ArrayList<>();
        doFindDuplicate1(root, visitedTrees, duplicateTrees);
        return duplicateTrees;
    }
    private static void doFindDuplicate1(TreeNode root, HashMap<String, Integer> visitedTrees, List<TreeNode> duplicateTrees) {
        if (root == null) {
            return;
        }
        String str = serialize(root);
        int count = visitedTrees.getOrDefault(str, 0);
        if (count == 0) {
            visitedTrees.put(str, 1);
        } else if (count == 1) {

        }
        doFindDuplicate1(root.left, visitedTrees, duplicateTrees);
        doFindDuplicate1(root.right, visitedTrees, duplicateTrees);
    }

    private static String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + root.right;
    }

}
