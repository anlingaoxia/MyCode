package src;

import node.TreeNode;

public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return false;
        }
        return depthHelper(root) != -1;
    }

    public int depthHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depthHelper(node.left);
        int right = depthHelper(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
