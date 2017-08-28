package src;

import node.TreeNode;

public class 二叉树的深度 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depthHelper(root, 1);
    }

    public int depthHelper(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(depthHelper(node.left, depth + 1), depthHelper(node.right, depth + 1));
    }
}
