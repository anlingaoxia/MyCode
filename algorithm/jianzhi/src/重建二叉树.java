package src;

import node.TreeNode;

public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return reConstruct(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode reConstruct(int[] pre, int[] in, int pS, int pE, int iS, int iE) {
        if (pS > pE) {
            return null;
        }

        TreeNode root = new TreeNode(pre[pS]);
        int iR = iS;
        while (in[iR] != root.val) {
            iR++;
        }
        int left = iR - iS;
        root.left = reConstruct(pre, in, pS + 1, pS + left, iS, iR - 1);
        root.right = reConstruct(pre, in, pS + left + 1, pE, iR + 1, iE);
        return root;
    }

}
