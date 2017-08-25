package transform;

public class N617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int findComplement(int num) {
        int count = 0;
        int t = num;
        while (t != 0) {
            t = t >>> 1;
            count++;
        }
        return (1 << count) - 1 - num;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
