package transform.medium2;


import lib.TreeNode;

public class N106 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        return create(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static TreeNode create(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart > postEnd) return null;
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int index = search(inOrder, inStart, inEnd, root.val);
        root.left = create(inOrder, postOrder, inStart, index - 1, postStart, postStart + index - 1 - inStart);
        root.right = create(inOrder, postOrder, index + 1, inEnd, postStart + index - inStart, postEnd - 1);
        return root;
    }

    public static int search(int[] inOrder, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == val) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = { 1, 2 };
        int[] postorder = { 2, 1 };
        System.out.println(buildTree(inorder, postorder).val);
    }
}
