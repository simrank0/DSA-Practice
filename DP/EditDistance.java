package DP;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        int[][] dp = new int[c1.length][c2.length];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return match(c1, c2, 0, 0, dp);
    }

    private int match(char[] c1, char[] c2, int i, int j, int[][] dp) {
        if (c1.length == i) return c2.length - j;
        if (c2.length == j) return c1.length - i;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (c1[i] == c2[j]) {
            dp[i][j] = match(c1, c2, i + 1, j + 1, dp);
        } else {
            //Case1: insert
            int insert = match(c1, c2, i, j + 1, dp);
            //Case2: delete
            int delete = match(c1, c2, i + 1, j, dp);
            //Case3: replace
            int replace = match(c1, c2, i + 1, j + 1, dp);

            dp[i][j] = Math.min(Math.min(insert, delete), replace) + 1;
        }

        return dp[i][j];
    }
}
