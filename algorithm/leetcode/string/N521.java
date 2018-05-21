package string;

public class N521 {

    public int findHelper(char[] cs1, char[] cs2, int s1, int e1, int s2, int e2) {
        boolean hasEquels = false;
        int equal1 = -1, equal2 = -1;
        outer:for (int i = s1; i <= e1; i++) {
            for (int j = s2; j <= e2; j++) {
                if (cs1[i] == cs2[j]) {
                    hasEquels = true;
                    equal1 = i;
                    equal2 = j;
                    break outer;
                }
            }
        }
        if (!hasEquels) return Math.min(e1 - s1 + 1, e2 - s2 + 1);
        int lr = findHelper(cs1, cs2, equal1 + 1, e1, equal2 + 1, e2);
        int ll = Math.min(equal1 - s1, equal2 - s2);
        return Math.max(ll, lr);
    }
}
