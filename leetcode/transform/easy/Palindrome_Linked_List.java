package transform.easy;

import java.util.LinkedList;


public class Palindrome_Linked_List {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        } else if (head.next == null) {
            return false;
        }
        ListNode temp1 = head;
        ListNode temp2 = head;
        do {
            temp1 = temp1.next;
            temp2 = temp2.next.next;
            if (temp1 == temp2) {
                return true;
            }
            if (temp2 == null) {
                return false;
            }
        } while (temp2.next != null);

        return false;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode last = reverseListNode(null, getTheMid(head).next);
        while (head != null && last != null) {
            if (head.val != last.val) return false;
            head = head.next;
            last = last.next;
        }
        return true;
    }

    public static ListNode getTheMid(ListNode head) {
        ListNode temp1 = head, temp2 = head;
        while (temp2.next != null && temp2.next.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        return temp1;
    }

    public static ListNode reverseListNode(ListNode last, ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode temp = reverseListNode(node, node.next);
        node.next = last;
        return temp == null ? node : temp;
    }

    public static void main(String[] args) {
        int[] t = { 1, 2, 3, 4, 2 };

        ListNode root = new ListNode(t[0]);
        ListNode temp = root;
        for (int i = 1; i < t.length; i++) {
            temp = temp.next = new ListNode(t[i]);
        }
        // temp = get(null, root);
        // // temp = root;
        // while (temp != null) {
        // System.out.println(temp.val);
        // temp = temp.next;
        // }
        System.out.println(isPalindrome(root));
    }

}

class A {
    public boolean isPalindrome(Palindrome_Linked_List.ListNode head) {
        LinkedList<Integer> list = get(head, new LinkedList<>());
        while (list.size() > 1) {
            if (list.getFirst().equals(list.getLast())) {
                list.removeFirst();
                list.removeLast();
            } else {
                return false;
            }
        }
        return true;
    }

    public LinkedList<Integer> get(Palindrome_Linked_List.ListNode node, LinkedList<Integer> list) {
        if (node == null) {
            return list;
        }
        list.add(node.val);
        return get(node.next, list);
    }
}