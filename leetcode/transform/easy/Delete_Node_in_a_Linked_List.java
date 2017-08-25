package transform.easy;

public class Delete_Node_in_a_Linked_List {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // ��ɾ���ķ�ʽ
    public static void deleteNode(ListNode node) {
        ListNode temp = node.next;
        if (temp != null) {
            node.val = temp.val;
            node.next = temp.next;
            temp.next = null;
        } else {
            node.next = null;
        }

    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        node0.next = node1;

        deleteNode(node0);

    }

}
