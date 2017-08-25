package transform.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        get(list, root);
        return list;
    }

    public void get(List<Integer> list, TreeNode node) {
        if (node == null) return;

        get(list, node.left);
        list.add(node.val);
        get(list, node.right);
    }

    public static List<Integer> iterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            temp = stack.peek().left;
            if (temp != null) {
                stack.push(temp);
            } else {
                temp = stack.pop();
                if (!stack.isEmpty()) stack.peek().left = null;
                list.add(temp.val);
                if (temp.right != null) stack.push(temp.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 20));

    }

}
