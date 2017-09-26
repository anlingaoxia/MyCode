package 最短路径;

public class Floyd {
    public static int getPath(int[][] graph, int start, int end) {
        if (start == end) return 0;
        for (int m = 0; m < graph.length; m++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (i == j) continue;
                    if (graph[i][m] == Integer.MAX_VALUE || graph[m][j] == Integer.MAX_VALUE) continue;
                    if (graph[i][j] > graph[i][m] + graph[m][j]) {
                        graph[i][j] = graph[i][m] + graph[m][j];
                    }
                }
            }
        }
        return graph[start][end];
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
        System.out.println(getPath(graph, 0, 5));
    }


}
