package transform.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Path_Sum_III {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int pathSum(TreeNode root, int sum) {
        return get(root, sum, new ArrayList<Integer>());
    }

    // 84ms
    public static int get(TreeNode node, int sum, List<Integer> counts) {
        if (node == null) {
            return 0;
        }
        ArrayList<Integer> temp = new ArrayList<>(counts);
        int here = 0;
        for (int i = 0; i < temp.size(); i++) {
            int add = temp.get(i) + node.val;
            if (add == sum) {
                here++;
            }
            temp.set(i, add);
        }
        if (node.val == sum) {
            here++;
        }
        temp.add(node.val);

        int left = get(node.left, sum, temp);
        int right = get(node.right, sum, temp);

        return here + left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(pathSum(root, 8));
    }

    public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int sum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        sum += root.val;
        int res = preSum.getOrDefault(sum - target, 0);
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);

        res += helper(root.left, sum, target, preSum) + helper(root.right, sum, target, preSum);
        preSum.put(sum, preSum.get(sum) - 1);
        return res;
    }
}
