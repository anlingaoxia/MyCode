package binarytree;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Levelorder {
    public static void print(TreeNode root, List<Integer> list) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tmp = root;
        queue.add(tmp);
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            list.add(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createDefaultTree();
        List<Integer> list = new ArrayList<>();
        print(root, list);
        System.out.println(list);
    }


}
