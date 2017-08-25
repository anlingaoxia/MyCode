package transform.easy;

public class Path_Sum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return get(root, 0, sum);
    }

    public boolean get(TreeNode node, int sum, int target) {
        if(node == null) {
            return false;
        }
        
        if (node.left == null && node.right == null) {
            return sum + node.val == target;
        }

        return get(node.left, sum + node.val, target) || get(node.right, sum + node.val, target);
    }

}
