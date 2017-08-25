package lib;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int x) {
        val = x;
    }


    public static TreeNode createTree(Integer[] array) {
        Queue<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        list.add(root);
        int index = 1;
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            if (index < array.length) {
                node.left = new TreeNode(array[index++]);
                list.add(node.left);
            }
            if (index < array.length) {
                node.right = new TreeNode(array[index++]);
                list.add(node.right);
            }
        }
        return root;
    }

    public static TreeNode createDefaultTree() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        return createTree(array);
    }


}
