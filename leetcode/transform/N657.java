package transform;

public class N657 {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return false;
        }
        int[] buckets = new int[128];
        for (int i = 0; i < moves.length(); i++) {
            buckets[moves.charAt(i)]++;
        }
        return buckets['U'] == buckets['D'] && buckets['L'] == buckets['R'];
    }
}
