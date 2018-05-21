package src;

import node.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class 按之字形顺序打印二叉树 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        if (pRoot == null) {
            return all;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        Stack<TreeNode> has, empty;
        stack1.add(pRoot);
        boolean leftToRight = false;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            has = stack1.isEmpty() ? stack2 : stack1;
            empty = stack1.isEmpty() ? stack1 : stack2;
            ArrayList<Integer> list = new ArrayList();
            if (!leftToRight) {
                while (!has.isEmpty()) {
                    TreeNode pop = has.pop();
                    list.add(pop.val);
                    if (pop.left != null) {
                        empty.push(pop.left);
                    }
                    if (pop.right != null) {
                        empty.push(pop.right);
                    }
                }
            } else {
                while (!has.isEmpty()) {
                    TreeNode pop = has.pop();
                    list.add(pop.val);
                    if (pop.right != null) {
                        empty.push(pop.right);
                    }
                    if (pop.left != null) {
                        empty.push(pop.left);
                    }
                }
            }
            leftToRight = !leftToRight;
            all.add(list);
        }
        return all;
    }

    public static void main(String[] args) {
        Integer[] array = {8, 6, 10, 5, 7, 9, 11};
        TreeNode root = TreeNode.createTree(array);
        System.out.println(Print(root));
    }
}
