package transform.easy;

public class Reverse_Linked_List {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode top = get(head);
        head.next = null;
        return top;
    }
    
    public static ListNode get(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode temp = head.next;
        if (temp == null) {
            return head;
        }
        ListNode top = get(temp);
        temp.next = head;
        return top;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
    }

}
