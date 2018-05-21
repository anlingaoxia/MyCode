package src;

import node.RandomListNode;

public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        copy(pHead);
        RandomListNode root = pHead.next;
        copyRandom(pHead);
        delete(pHead);
        return root;
    }

    public void copy(RandomListNode pHead) {
        if (pHead == null) return;
        RandomListNode cNode = new RandomListNode(pHead.label);
        cNode.next = pHead.next;
        pHead.next = cNode;
        copy(cNode.next);
    }

    public void copyRandom(RandomListNode pHead) {
        if (pHead == null) return;
        if (pHead.random != null) pHead.next.random = pHead.random.next;
        copyRandom(pHead.next.next);
    }

    public void delete(RandomListNode pHead) {
        if (pHead == null) return;
        RandomListNode cNode = pHead.next;
        pHead.next = cNode.next;
        if (cNode.next != null) cNode.next = cNode.next.next;
        delete(pHead.next);
    }
}
