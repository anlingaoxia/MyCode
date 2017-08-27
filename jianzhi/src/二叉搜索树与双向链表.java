package src;

import node.TreeNode;

import java.util.ArrayList;

public class 二叉搜索树与双向链表 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        convertHelper(pRootOfTree, list);
        link(list);
        return list.get(0);
    }

    public void convertHelper(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) {
            return;
        }
        convertHelper(node.left, list);
        list.add(node);
        convertHelper(node.right, list);
    }

    public void link(ArrayList<TreeNode> list) {
        for (int i = 1; i < list.size() - 1; i++) {
            list.get(i).left = list.get(i - 1);
            list.get(i).right = list.get(i + 1);
        }
        if (list.size() > 2) {
            list.get(0).right = list.get(1);
            list.get(list.size() - 1).left = list.get(list.size() - 2);
        }
    }


}
