package arithmetic.exercise.easy.tree;

import arithmetic.exercise.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 层序遍历
 */
public class LevelOrder {

    private static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        doLevelOrder(root, 0, list);
        return list;
    }

    private static void doLevelOrder(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        List<Integer> currentLevelList;
        if (level >= list.size()) {
            currentLevelList = new ArrayList<>();
            list.add(level, currentLevelList);
        } else {
            currentLevelList = list.get(level);
        }
        currentLevelList.add(root.val);
        level++;
        doLevelOrder(root.left, level, list);
        doLevelOrder(root.right, level, list);
    }

    public static void main(String[] args) {
        /*
         *              3
         *           /     \
         *         9       20
         *               /   \
         *              15   7
         */

        TreeNode root = new TreeNode(3);

        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);

        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;

        List<List<Integer>> result = solution(root);

    }

}
