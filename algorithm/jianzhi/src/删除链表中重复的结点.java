package src;

import node.ListNode;

public class 删除链表中重复的结点 {
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode next = pHead.next;
        delete(pHead, pHead.next);
        if (next != null && pHead.val == next.val) {
            return pHead.next;
        }
        return pHead;
    }

    public static void delete(ListNode last, ListNode node) {
        if (node == null) {
            return;
        }
        ListNode next = node.next;
        delete(node, node.next);
        if (last.val == node.val || next != null && node.val == next.val) {
            last.next = node.next;
            node.next = null;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 1, 1, 2};
        ListNode root = ListNode.createListNode(array);
        ListNode.printListNode(deleteDuplication(root));
    }
}
