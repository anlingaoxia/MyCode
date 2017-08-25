package transform.medium2;


import lib.TreeNode;

public class N105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return get(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode get(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = search(inOrder, inStart, inEnd, root.val);
        root.left = get(preOrder, inOrder, preStart + 1, preStart + index - inStart, inStart, index - 1);
        root.right = get(preOrder, inOrder, preStart + index - inStart + 1, preEnd, index + 1, inEnd);
        return root;
    }

    public static int search(int[] inOrder, int start, int end, int val) {
        for (int i = start; i <= end; i++)
            if (inOrder[i] == val) return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = { 1, 2 };
        int[] postorder = { 2, 1 };
        System.out.println(buildTree(inorder, postorder).val);
    }
}
