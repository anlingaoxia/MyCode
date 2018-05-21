package src;

import node.ListNode;

import java.util.Stack;

public class 反转链表 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        ListNode root = stack.pop();
        tmp = root;
        while (!stack.isEmpty()) {
            tmp.next = stack.pop();
            tmp = tmp.next;
        }
        tmp.next = null;
        return root;
    }


    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode foot = reverseHelper(head);
        head.next = null;
        return foot;
    }

    public ListNode reverseHelper(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode rlt = reverseHelper(node.next);
        if (rlt == null) {
            return node;
        }
        node.next.next = node;
        return rlt;
    }


}
