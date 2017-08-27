package src;

import node.TreeNode;

public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean root = compare(root1, root2);
        return root ? true : compare(root1.left, root2) | compare(root1.right, root2);
    }


    public boolean compare(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null && node2 != null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return compare(node1.left, node2.left) & compare(node1.right, node2.right);
    }


}
