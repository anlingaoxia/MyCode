package transform.easy;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return get(0, nums.length - 1, nums);
    }

    public TreeNode get(int start, int end, int[] nums) {
        if (start == end) {
            return new TreeNode(nums[start]);
        } else if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = get(start, mid - 1, nums);
        root.right = get(mid + 1, end, nums);
        return root;
    }
}
