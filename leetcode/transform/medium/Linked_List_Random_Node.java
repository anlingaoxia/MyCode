package transform.medium;

public class Linked_List_Random_Node {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode root;

    public Linked_List_Random_Node(ListNode head) {
        this.root = head;
    }

    public int getRandom() {
        double random = Math.random();

        return 0;
    }

    int count = 0;
    boolean has = false;

    public int get(ListNode node, double random) {
        if (node == null) return -1;
        int n = count++;
        int next = get(node.next, random);
        if (has) return next;
        else if (random * count == n) {
            has = true;
            return node.val;
        }
        return -1;
    }
    
    public static void main(String[] args) {
    }

}
