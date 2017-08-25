package transform.easy;

public class Remove_Linked_List_Elements {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        return get(head, val);
    }

    public static ListNode get(ListNode node, int target) {
        if (node.next == null) return node.val == target ? null : node;
        ListNode temp = get(node.next, target);
        node.next = temp;
        return node.val == target ? node.next : node;
    }

}
