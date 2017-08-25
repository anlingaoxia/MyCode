package transform.easy;

public class Maximum_Depth_of_Binary_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int maxDepth;

    public static int maxDepth(TreeNode root) {

        return findMax(root, 1);
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
    }

    public static int findMax(TreeNode node, int depth) {
        if (node == null) return depth - 1;
        int left = findMax(node.left, depth + 1);
        int right = findMax(node.right, depth + 1);
        return Math.max(left, right);
    }

    public static void findMax2(TreeNode node, int depth) {
        if (node == null) return;

        if (node.left != null) {
            findMax2(node.left, depth + 1);
        }

        if (node.right != null) {
            findMax2(node.right, depth + 1);
        }

        if (depth > maxDepth) {
            maxDepth = depth;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.right.right = new TreeNode(0);
        System.out.println(maxDepth(root));
    }

}
