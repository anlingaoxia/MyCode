package src;

import node.ListNode;

public class 合并两个排序的链表 {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode root = mergeHelper(list1, list2);
        ListNode tmp = root, node1 = list1, node2 = list2;
        while (tmp != null) {
            if (tmp == node1) {
                node1 = node1.next;
            } else if (tmp == node2) {
                node2 = node2.next;
            }
            tmp.next = mergeHelper(node1, node2);
            tmp = tmp.next;
        }
        return root;
    }

    public static ListNode mergeHelper(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }
        return node1.val < node2.val ? node1 : node2;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 9};
        int[] a2 = {2, 4, 6, 8, 10};
        ListNode list1 = ListNode.createListNode(a1);
        ListNode list2 = ListNode.createListNode(a2);
        ListNode.printListNode(Merge(list1, list2));
    }

}
