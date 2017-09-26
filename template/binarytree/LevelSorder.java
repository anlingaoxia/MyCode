package binarytree;

import node.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LevelSorder {
    public static void print(TreeNode root, List<Integer> list) {
        LinkedList<TreeNode> record = new LinkedList<>();
        record.add(root);
        boolean addLeftToRight = false;
        while (!record.isEmpty()) {
            int size = record.size();
            if (addLeftToRight) {
                for (; size > 0; size--) {
                    TreeNode tmp = record.removeLast();
                }
            }
        }


    }


}
