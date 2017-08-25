package transform.easy2;

public class First_Bad_Version {
    // public static int firstBadVersion2(int n) {
    // int k = (int) Math.ceil(Math.sqrt(2 * n + 0.25) - 0.5);
    // System.out.println("k:" + k);
    // int times = 0;
    // int firstN = n + 1;
    // int lastN = n;
    // while (lastN > 0) {
    // lastN = firstN - 1;
    // firstN -= (k - times);
    // if (firstN <= 1 && isBadVersion(1)) {
    // return 1;
    // } else if (firstN > 1 && isBadVersion(firstN)) {
    // times++;
    // continue;
    // }
    // for (int i = firstN + 1; i <= lastN; i++) {
    // if (isBadVersion(i)) return i;
    // }
    // return firstN + k - times;
    // }
    // return 0;
    // }
    //
    // public static int firstBadVersion(int n) {
    // int times = 0;
    // int firstN = 0;
    // int lastN = 0;
    //
    // while (firstN <= n) {
    // firstN = lastN + 1;
    // lastN = firstN + times;
    // if (lastN > n) lastN = n;
    //// System.out.println("firstN:" + firstN + " " + "lastN:" + lastN);
    // if (isBadVersion(lastN)) {
    // for (int i = lastN - 1; i >= firstN; i--) {
    // if (!isBadVersion(i)) {
    // return i + 1;
    // }
    // }
    // return firstN;
    // } else {
    // times++;
    // }
    // }
    // return 0;
    // }

    public static int firstBadVersion(int n) {
        boolean isStart = isBadVersion(1);
        if (isStart) return 1;
        boolean isEnd = isBadVersion(n);
        return get(1, n, isStart, isEnd);
    }

    public static int get(int start, int end, boolean isStart, boolean isEnd) {
        if (start >= end - 1) return end;
        int mid = (int) (start / 2.0 + end / 2.0);
        System.out.println(mid);
        boolean isMid = isBadVersion(mid);

        if (isMid) {
            return get(start, mid, isStart, isMid);
        } else {
            return get(mid, end, isMid, isEnd);
        }
    }

    public static boolean isBadVersion(int n) {
        if (n >= 2) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }

}
