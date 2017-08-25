package transform.easy;

import java.util.ArrayList;
import java.util.List;

public class Symmetric_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();
        get(root, list, 0);
        for (List<TreeNode> temp : list) {
            for (int i = 0, j = temp.size() - 1; i < j; i++, j--) {
                if (temp.get(i) != null && temp.get(j) != null) {
                    if (temp.get(i).val != temp.get(j).val) {
                        return false;
                    }
                } else if (temp.get(i) == null && temp.get(j) != null) {
                    return false;
                } else if (temp.get(i) != null && temp.get(j) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void get(TreeNode node, List<List<TreeNode>> list, int ceil) {
        if (ceil == list.size()) {
            list.add(new ArrayList<TreeNode>());
        }
        if (node == null) {
            list.get(ceil).add(null);
            return;
        }
        list.get(ceil).add(node);
        get(node.left, list, ceil + 1);
        get(node.right, list, ceil + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        List<List<TreeNode>> list = new ArrayList<>();
        get(root, list, 0);
        System.out.println(isSymmetric(root));

    }

}
