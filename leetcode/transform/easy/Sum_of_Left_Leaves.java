package transform.easy;

public class Sum_of_Left_Leaves {
    // 9ms
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return findLeftSum(root.left, true) + findLeftSum(root.right, false);
    }

    public static int findLeftSum(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        int left = findLeftSum(node.left, true);
        int right = findLeftSum(node.right, false);

        if (isLeft && node.left == null && node.right == null) {
            return node.val;
        } else {
            return left + right;
        }
    }

    // public static int sumOfLeftLeaves(TreeNode root) {
    // if (root == null) return 0;
    // int ans = 0;
    // Stack<TreeNode> stack = new Stack<TreeNode>();
    // stack.push(root);
    //
    // while (!stack.empty()) {
    // TreeNode node = stack.pop();
    // if (node.left != null) {
    // if (node.left.left == null && node.left.right == null) ans += node.left.val;
    // else stack.push(node.left);
    // }
    // if (node.right != null) {
    // if (node.right.left != null || node.right.right != null) stack.push(node.right);
    // }
    // }
    // return ans;
    // }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(sumOfLeftLeaves(root));
    }

}
