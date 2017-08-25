package transform.easy;

public class Swap_Nodes_in_Pairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        return swapPairs(null, head, true);
    }

    public static ListNode swapPairs(ListNode last, ListNode node, boolean lastSwap) {
        if (node == null) {
            return null;
        }
        ListNode temp = node.next;
        if (lastSwap) {
            node.next = swapPairs(node, node.next, false);
            return temp == null ? node : temp;
        } else {
            temp = swapPairs(node, node.next, true);
            node.next = last;
            return temp;
        }
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode temp = node0;
        temp = temp.next = new ListNode(1);
        temp = temp.next = new ListNode(2);
         temp = temp.next = new ListNode(3);
        // temp = temp.next = new ListNode(4);
        // temp = temp.next = new ListNode(5);
        // temp = temp.next = new ListNode(6);
        // temp = temp.next = new ListNode(7);
        temp = swapPairs(node0);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
