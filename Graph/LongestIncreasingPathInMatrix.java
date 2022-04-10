package Graph;

import java.util.PriorityQueue;

public class LongestIncreasingPathInMatrix {
    private static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int maxLen = 0;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        PriorityQueue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPQ.offer(new int[]{i, j, matrix[i][j]});
            }
        }

        int[][] dp = new int[n][m];
        while (!maxPQ.isEmpty()) {
            int[] cell = maxPQ.poll();
            int i = cell[0], j = cell[1];
            dp[i][j] = 1;
            for (int[] d: dir) {
                int newI = i + d[0], newJ = j + d[1];
                if (newI < 0 || newI >= n || newJ < 0 || newJ >= m || matrix[i][j] >= matrix[newI][newJ]) continue;
                dp[i][j] = Math.max(dp[i][j], dp[newI][newJ] + 1);
            }

            maxLen = Math.max(maxLen, dp[i][j]);
        }

        return maxLen;
    }
}
