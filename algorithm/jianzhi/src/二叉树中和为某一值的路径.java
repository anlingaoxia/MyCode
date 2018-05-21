package src;

import node.TreeNode;

import java.util.ArrayList;
//1.前序遍历二叉树每个节点
//2.对每个节点进行以该节点为起点的路径搜索
public class 二叉树中和为某一值的路径 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        if (root == null) {
            return all;
        }
        findIterator(root, target, all);
        return all;
    }

    public void findIterator(TreeNode node, int target, ArrayList<ArrayList<Integer>> all) {
        if (node == null) {
            return;
        }
        findHelper(node, target, all, new ArrayList<Integer>());
        findIterator(node.left, target, all);
        findIterator(node.right, target, all);
    }

    public void findHelper(TreeNode node, int remain, ArrayList<ArrayList<Integer>> all, ArrayList<Integer> list) {
        if (node == null) {
            return;
        } else if (remain == node.val) {
            list.add(node.val);
            all.add(list);
        }
        remain -= node.val;
        ArrayList<Integer> tList = new ArrayList<>(list);
        tList.add(node.val);
        findHelper(node.left, remain, all, tList);
        findHelper(node.right, remain, all, tList);
    }

}
