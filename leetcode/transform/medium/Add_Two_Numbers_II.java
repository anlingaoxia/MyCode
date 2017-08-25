package transform.medium;

import java.util.ArrayList;
import java.util.List;

public class Add_Two_Numbers_II {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = getAddUp(l1);
        List<Integer> list2 = getAddUp(l2);
        List<Integer> list3 = new ArrayList<>();
        ListNode root = null;
        int addUp = 0;
        int add1 = 0;
        int add2 = 0;
        System.out.println(list1);
        System.out.println(list2);
        for (int i = list1.size() - 1, j = list2.size() - 1; i >= 0 || j >= 0; i--, j--) {
            if (i < 0) add1 = 0;
            else add1 = list1.get(i);
            if (j < 0) add2 = 0;
            else add2 = list2.get(j);
            int all = add1 + add2 + addUp;
            System.out.println(all);
            addUp = all / 10;
            int n = all % 10;
            list3.add(n);
        }
        System.out.println(list3);
        if (addUp > 0) {
            System.out.println("jinwei");
            root = new ListNode(1);
            System.out.println(root.val);
            if (list1.size() >= list2.size()) {
                ListNode temp = l1;
                for (int i = list3.size() - 1; i >= 0; i--) {
                    temp.val = list3.get(i);
                    temp = temp.next;
                }
                root.next = l1;
                return root;
            } else {
                ListNode temp = l2;
                for (int i = list3.size() - 1; i >= 0; i--) {
                    temp.val = list3.get(i);
                    temp = temp.next;
                }
                root.next = l2;
                return root;
            }
        } else {
            System.out.println("NOT jinwei");
            if (list1.size() >= list2.size()) {
                ListNode temp = l1;
                for (int i = list3.size() - 1; i >= 0; i--) {
                    temp.val = list3.get(i);
                    temp = temp.next;
                }
                return l1;
            } else {
                ListNode temp = l2;
                for (int i = list3.size() - 1; i >= 0; i--) {
                    temp.val = list3.get(i);
                    temp = temp.next;
                }
                return l2;
            }
        }
    }

    public static List<Integer> getAddUp(ListNode node) {
        List<Integer> list = new ArrayList<>();
        list.add(node.val);
        ListNode temp = node;
        while (temp.next != null) {
            list.add(temp.next.val);
            temp = temp.next;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 3 };
        System.out.println(findDisappearedNumbers(nums));

    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            res[nums[i] - 1]++;

        for (int j = 1; j <= res.length; j++)
            if (res[j - 1] == 0) result.add(j);
        return result;
    }

}
