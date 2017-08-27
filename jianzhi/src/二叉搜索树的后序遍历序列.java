package src;

public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return subTree(sequence, 0, sequence.length - 1);
    }

    public boolean subTree(int[] sequence, int start, int end) {
        if (start + 1 >= end) {
            return true;
        }
        int root = sequence[end], leftEnd = start;
        while (sequence[leftEnd] < root) {
            leftEnd++;
        }


        boolean left = true, right = true;
        for (int i = start; i < leftEnd; i++) {
            if (sequence[i] > root) left = false;
        }
        for (int i = leftEnd; i < end; i++) {
            if (sequence[i] < root) right = false;
        }
        return left & right & subTree(sequence, start, leftEnd - 1) & subTree(sequence, leftEnd, end - 1);
    }
}
