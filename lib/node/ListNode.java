package node;

public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createListNode(int[] array) {
        ListNode root = new ListNode(array[0]);
        ListNode tmp = root;
        for (int i = 1; i < array.length; i++) {
            tmp.next = new ListNode(array[i]);
            tmp = tmp.next;
        }
        return root;
    }

    public static void printListNode(ListNode root) {
        while (root != null) {
            System.out.print(root.val + "  ");
            root = root.next;
        }
        System.out.println();
    }

}

