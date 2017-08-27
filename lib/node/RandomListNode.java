package node;

public class RandomListNode {
    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }

    public static RandomListNode createRandomListNode(int[] array) {
        RandomListNode root = new RandomListNode(array[0]);
        RandomListNode tmp = root;
        for (int i = 1; i < array.length; i++) {
            tmp.next = new RandomListNode(array[i]);
            tmp = tmp.next;
        }
        return root;
    }

    public static void printRandomListNode(RandomListNode root) {
        while (root != null) {
            System.out.print(root.label + "  ");
            root = root.next;
        }
        System.out.println();
    }
}