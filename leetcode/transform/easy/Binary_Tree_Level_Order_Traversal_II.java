package transform.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal_II {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        get(root, list, 0);
        Collections.reverse(list);
        return list;
    }

    public static void get(TreeNode node, List<List<Integer>> list, int ceil) {
        if (node == null) {
            return;
        }
        if (ceil == list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(ceil).add(node.val);
        get(node.left, list, ceil + 1);
        get(node.right, list, ceil + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(levelOrderBottom(root));
    }

}
