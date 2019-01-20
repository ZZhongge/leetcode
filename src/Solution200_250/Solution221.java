package Solution200_250;

class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if ((matrix.length) == 0 || ((matrix[0].length) == 0)) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        dfs(matrix, 0, 0, dp);
        int maxnumber = 0;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxnumber = Math.max(maxnumber, dp[i][j]);
            }
        }
        return maxnumber * maxnumber;
    }

    public int dfs(char[][] matrix, int i, int j, int[][] dp) {
        if (i > matrix.length - 1 || j > matrix[0].length - 1) {
            return 0;
        }
        if (dp[i][j] == -1) {
            int minval = Math.min(Math.min(dfs(matrix, i + 1, j, dp), dfs(matrix, i, j + 1, dp)), dfs(matrix, i + 1, j + 1, dp));
            int myval = matrix[i][j] == '1' ? 1 : 0;
            if (myval == 0) {
                dp[i][j] = 0;
            } else {
                dp[i][j] = minval + myval;
            }
        }
        return dp[i][j];
    }
}
