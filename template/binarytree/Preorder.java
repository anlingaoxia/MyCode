package binarytree;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {
    public static void printRecursively(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        printRecursively(root.left, list);
        printRecursively(root.right, list);
    }

    public static void printIteratively(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp != null) {
                list.add(tmp.val);
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.pop().right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createDefaultTree();
        List<Integer> list = new ArrayList<>();
        printIteratively(root, list);
        System.out.println(list);
    }


}
