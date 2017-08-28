package src;

import node.ListNode;

public class 两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int l1 = 0, l2 = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != null) {
            p1 = p1.next;
            l1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            l2++;
        }
        p1 = pHead1;
        p2 = pHead2;
        while (l1 > l2) {
            p1 = p1.next;
            l1--;
        }
        while (l2 > l1) {
            p2 = p2.next;
            l2--;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
