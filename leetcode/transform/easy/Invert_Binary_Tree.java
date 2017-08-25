package transform.easy;

public class Invert_Binary_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        invertTrees(root);
        return root;
    }

    public static void invertTrees(TreeNode node) {
        if (node == null) return;
        invertTrees(node.left);
        invertTrees(node.right);
        exchangeNode(node);
    }

    public static void exchangeNode(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        
        invertTree(root);
        System.out.println(root.right.val);
        System.out.println(root.right.right.val);
        System.out.println(root.left.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.left.left.val);
        
    }
    
}
