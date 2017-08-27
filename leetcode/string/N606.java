package string;

import node.TreeNode;

public class N606 {
    public static String tree2str(TreeNode t) {
        if (t == null) return "";
        return builder(t);
    }

    public static String builder(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder(String.valueOf(root.val));
        String left = builder(root.left);
        String right = builder(root.right);
        if (left.equals("") && right.equals("")) return sb.toString();
        sb.append("(").append(left).append(")");
        if (!right.equals("")) sb.append("(").append(right).append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(-3);
        root.left.left.left = new TreeNode(-4);
        System.out.println(tree2str(root));
    }
}
