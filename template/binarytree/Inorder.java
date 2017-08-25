package binarytree;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
    public static void printRecursively(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        printRecursively(root.left, list);
        list.add(root.val);
        printRecursively(root.right, list);
    }

    public static void printIteratively(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop();
                list.add(tmp.val);
                tmp = tmp.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createDefaultTree();
        List<Integer> list = new ArrayList<>();
        printRecursively(root, list);
        System.out.println(list);
    }



}
