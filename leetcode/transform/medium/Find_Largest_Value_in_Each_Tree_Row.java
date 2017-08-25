package transform.medium;

import java.util.ArrayList;
import java.util.List;

public class Find_Largest_Value_in_Each_Tree_Row {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        get(list, root, 0);
        return list;
    }

    public static void get(ArrayList<Integer> list, TreeNode node, int depth) {
        if (node == null) return;
        if (list.size() <= depth) {
            list.add(node.val);
        } else if (list.get(depth) < node.val) {
            list.set(depth, node.val);
        }
        get(list, node.left, depth + 1);
        get(list, node.right, depth + 1);
    }
    
    public static void main(String[] args) {
        System.out.println();
        
    }

}
