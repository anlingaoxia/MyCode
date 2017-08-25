package transform.easy;

public class Same_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (q == null && p != null)) {
            return false;
        } else if (p == null && q == null) {
            return true;
        } else if (p.val != q.val) {
            return false;
        }

        boolean equalLeft = isSameTree(p.left, q.left);
        boolean equalRight = isSameTree(p.right, q.right);

        return equalLeft & equalRight;
    }

}
