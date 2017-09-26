package array;

public class Main {
    public static int get(int N, int K, int[] apple, int[][] connectedNodes) {
        boolean[] apples = new boolean[N + 1];
        for (int i : apple) {
            apples[i] = true;
        }
        boolean[][] tree = new boolean[N + 1][N + 1];
        boolean[][] has = new boolean[N + 1][N + 1];
        for (int[] conn : connectedNodes) {
            tree[conn[0]][conn[1]] = true;
            tree[conn[1]][conn[0]] = true;
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            int find = findNext(tree, has, apples, i);
            if (find > max) {
                max = find;
            }

        }
        return max;
    }

    public static int findNext(boolean[][] tree, boolean[][] has, boolean[] apples, int start) {
        int max = 0;
        for (int i = 1; i <= tree.length - 1; i++) {
            if (start == i) {
                continue;
            }
            if (tree[start][i] && !has[start][i]) {
                has[start][i] = true;
                has[i][start] = true;
                int find = findNext(tree, has, apples, i);
                if (find > max) max = find;
                has[start][i] = false;
                has[i][start] = false;
            }
        }
        return max + (apples[start] ? 1 : 0);
    }

    public static void main(String[] args) {
        int N = 4;
        int K = 3;
        int[] apple = {2, 3, 4};
        int[][] connectedNodes = {{1, 2}, {1, 3}, {1, 4}};
        System.out.println(get(N, K, apple, connectedNodes));
    }


}
