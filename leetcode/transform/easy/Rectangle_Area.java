package transform.easy;

public class Rectangle_Area {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length1 = C - A;
        int high1 = D - B;

        int length2 = G - E;
        int high2 = H - F;

        int count = 0;
        for (int x = E; x < G; x++) {
            for (int y = F; y < H; y++) {
                if (x >= A && x < C && y >= B && y < D) {
                    count++;
                }
            }
        }
        return length1 * high1 + length2 * high2 - count;
    }

    public static void main(String[] args) {
        System.out.println(computeArea(0, 0, 4, 4, 0, 0, 2, 2));
    }

}
