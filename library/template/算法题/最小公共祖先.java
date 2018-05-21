package 算法题;

import node.TreeNode;

public class 最小公共祖先 {
    public TreeNode minAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        return minHelper(root, node1, node2);
    }

    public TreeNode minHelper(TreeNode node, TreeNode node1, TreeNode node2) {
        if (node == null || node == node1 || node == node2) {
            return node;
        }
        TreeNode left = minHelper(node.left, node1, node2);
        TreeNode right = minHelper(node.right, node1, node2);
        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }

}
