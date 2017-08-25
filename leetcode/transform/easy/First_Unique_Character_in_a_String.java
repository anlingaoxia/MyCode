package transform.easy;

import java.util.LinkedList;
import java.util.List;

public class First_Unique_Character_in_a_String {
    public static class MQueue {
        public int capability = 2;

        public MQueue(int capability) {
            this.capability = capability;
        }

        public void push() {

        }
    }

    // 49ms linkedlist��ɾ�����ܻ��Ǻ�
    public static int firstUniqChar(String s) {
        int[] cHash = new int[123];
        List<Character> note = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            int p = s.charAt(i);
            Character c = Character.valueOf((char) p);
            cHash[p]++;
            if (cHash[p] == 1) {
                note.add(c);
            } else if (cHash[p] > 1 && note.contains(c)) {
                note.remove(c);
            }
        }
        if (note.size() == 0) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == note.get(0)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));

    }

}
