package src;


import node.ListNode;

public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        ListNode pk = firstKStep(head, k - 1);
        if (pk == null) return null;
        ListNode p0 = head;
        while (pk.next != null) {
            pk = pk.next;
            p0 = p0.next;
        }
        return p0;
    }

    public ListNode firstKStep(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        return k == 0 ? head : firstKStep(head.next, --k);
    }
}
