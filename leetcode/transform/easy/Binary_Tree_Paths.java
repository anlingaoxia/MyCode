package transform.easy;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        get(root, list, "");
        return list;
    }

    public static void get(TreeNode node, List<String> list, String s) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (s.length() != 0) {
                list.add(s + "->" + node.val);
            } else {
                list.add(s + node.val);
            }
            return;
        }
        if (s.length() != 0) {
            get(node.left, list, s + "->" + node.val);
            get(node.right, list, s + "->" + node.val);
        } else {
            get(node.left, list, String.valueOf(node.val));
            get(node.right, list, String.valueOf(node.val));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);
        System.out.println(binaryTreePaths(root));

    }

}
