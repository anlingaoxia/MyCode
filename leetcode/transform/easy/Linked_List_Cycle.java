package transform.easy;

import java.util.HashSet;
import java.util.Set;

public class Linked_List_Cycle {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        for (; temp1.next != null && temp2.next != null && temp2.next.next != null; temp1 = temp1.next, temp2 = temp2.next.next) {
            if (temp1 == temp2) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        return get(head, new HashSet<ListNode>());

    }

    public static boolean get(ListNode node, Set<ListNode> set) {
        if (node == null) {
            return false;
        }
        if (!set.add(node)) {
            return true;
        }
        return get(node.next, set);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        // node.next = node;
        System.out.println(hasCycle2(node));

    }

}
