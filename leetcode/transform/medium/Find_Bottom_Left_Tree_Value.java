package transform.medium;

public class Find_Bottom_Left_Tree_Value {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        int[] res = get(root, 1);
        return res[1];
    }

    public int[] get(TreeNode node, int depth) {
        if (node == null) {
            return null;
        }
        depth++;
        int[] left = get(node.left, depth);
        int[] right = get(node.right, depth);

        if (left == null && right == null) return new int[] { depth, node.val };
        else if (left == null && right != null) return right;
        else if (left != null && right == null) return left;
        else if (left[0] >= right[0]) return left;
        else return right;
    }

}
