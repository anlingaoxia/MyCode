package transform.easy;

public class Merge_Two_Sorted_Lists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode alter = null;

        while (temp1 != null && temp2 != null) {
            System.out.println(temp1.val + "    " + temp2.val);
            if (temp1.val <= temp2.val) {
                if (temp1.next != null) {
                    if (temp1.next.val >= temp2.val) {
                        alter = temp2;
                        temp2 = temp2.next;
                        insertAfter(temp1, alter);
                    }
                } else {
                    temp1.next = temp2;
                    break;
                }
                temp1 = temp1.next;
            } else {
                alter = temp2;
                temp2 = temp2.next;
                alter.next = temp1;
                temp1 = alter;
            }
        }
        if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 == null && l2 == null) {
            return null;
        }

        return l1.val <= l2.val ? l1 : l2;
    }

    public static void insertAfter(ListNode node1, ListNode node2) {
        ListNode temp = node1.next;
        node1.next = node2;
        node2.next = temp;
    }

    public static void main(String[] args) {
        ListNode temp;
        ListNode node1 = new ListNode(1);
//        temp = node1;
//        temp = temp.next = new ListNode(-9);
//        temp = temp.next = new ListNode(-6);
//        temp = temp.next = new ListNode(-4);
//        temp = temp.next = new ListNode(1);
//        temp = temp.next = new ListNode(9);
//        temp = temp.next = new ListNode(9);
        ListNode node2 = new ListNode(1);
//        temp = node2;
//        temp = temp.next = new ListNode(-3);
//        temp = temp.next = new ListNode(0);
//        temp = temp.next = new ListNode(7);
//        temp = temp.next = new ListNode(8);
//        temp = temp.next = new ListNode(8);
        // temp = temp.next = new ListNode(14);

        temp = mergeTwoLists(node1, node2);
        System.out.println();
        System.out.println();

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
