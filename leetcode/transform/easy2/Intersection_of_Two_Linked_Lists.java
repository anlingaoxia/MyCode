package transform.easy2;

public class Intersection_of_Two_Linked_Lists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pointA = headA;
        ListNode pointB = headB;
        int countA = 0;
        int countB = 0;

        while (pointA != null) {
            pointA = pointA.next;
            countA++;
        }

        while (pointB != null) {
            pointB = pointB.next;
            countB++;
        }
        pointA = headA;
        pointB = headB;
        if (countA == 0 || countB == 0) {
            return null;
        } else if (countA > countB) {
            for (int i = 0; i < countA - countB; i++)
                pointA = pointA.next;
        } else if (countA < countB) {
            for (int i = 0; i < countB - countA; i++)
                pointB = pointB.next;
        }

        while (pointA != null && pointB != null) {
            if (pointA == pointB) return pointA;
            pointA = pointA.next;
            pointB = pointB.next;
        }
        return null;
    }

}
