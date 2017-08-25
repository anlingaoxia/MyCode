package transform.easy;

public class Remove_Duplicates_from_Sorted_List {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = deleteDuplicates(head.next);
        if (head.val != head.next.val) {
            head.next = temp;
        } else {
            head.next = head.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        node0.next = new ListNode(1);
        node0.next.next = new ListNode(2);
        node0.next.next.next = new ListNode(2);
        node0.next.next.next.next = new ListNode(2);
        node0.next.next.next.next.next = new ListNode(3);
        node0.next.next.next.next.next.next = new ListNode(4);
        node0.next.next.next.next.next.next.next = new ListNode(4);
        node0.next.next.next.next.next.next.next.next = new ListNode(4);
        node0.next.next.next.next.next.next.next.next.next = new ListNode(5);
        deleteDuplicates(node0);

        while (node0 != null) {
            System.out.println(node0.val);
            node0 = node0.next;
        }

    }
}
