package src;

import node.ListNode;

import java.util.ArrayList;

public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        print(listNode, list);
        return list;
    }

    public void print(ListNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        print(node.next, list);
        list.add(node.val);
    }
}
