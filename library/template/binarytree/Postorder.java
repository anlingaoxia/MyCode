package binarytree;

import node.TreeNode;

import java.util.List;
import java.util.Stack;

public class Postorder {
    public static void printRecursively(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        printRecursively(root.left, list);
        printRecursively(root.right, list);
        list.add(root.val);
    }

    public static void printIteratively(TreeNode root, Stack<Integer> record) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp != null) {
                stack.push(tmp);
                record.push(tmp.val);
                tmp = tmp.right;
            } else {
                tmp = stack.pop().left;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createDefaultTree();
        Stack<Integer> record = new Stack<>();
        printIteratively(root, record);
        System.out.println(record);
    }

}
