package 最短路径;

import java.util.Arrays;

public class Dijkstra {
    public static int getPath(int[][] graph, int start, int end) {
        if (start == end) return 0;

        int[] l = graph[start];
        int[] p = new int[graph.length];
        boolean[] use = new boolean[graph.length];
        Arrays.fill(p, start);
        use[start] = true;

        while (true) {
            int next = findMinPath(l, use);
            update(graph, l, p, use, next);
            if (next == end) break;
        }

        int path = 0, last = end;
        while (last != start) {
            path += graph[p[last]][last];
            last = p[last];
        }
        return path;
    }

    public static int findMinPath(int[] l, boolean[] use) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l.length; i++) {
            if (!use[i] && l[i] < min) {
                min = i;
            }
        }
        use[min] = true;
        return min;
    }

    public static void update(int[][] graph, int[] l, int[] p, boolean[] use, int next) {
        for (int i = 0; i < graph.length; i++) {
            if (!use[i] && graph[next][i] != Integer.MAX_VALUE) {
                if (l[next] + graph[next][i] < l[i]) {
                    l[i] = l[next] + graph[next][i];
                    p[i] = next;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {1, 0, 3, 7, 5, Integer.MAX_VALUE},
                {5, 3, 0, Integer.MAX_VALUE, 1, 7},
                {Integer.MAX_VALUE, 7, Integer.MAX_VALUE, 0, 2, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 5, 1, 2, 0, 3},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 7, Integer.MAX_VALUE, 3, 0}
        };
        getPath(graph, 1, 5);
    }


}
