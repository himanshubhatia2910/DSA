class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n+1];

        int curr = 0, prev = (curr + 1) % 2;
        for(int i=1;i<=n;i++) {
            dp[curr%2][i] = 1;
        }
        curr = (curr + 1) % 2;
        prev = (curr + 1) % 2;

        for(int i = 2;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                dp[curr%2][j] = dp[prev%2][j];
                if(j>=2) {
                    dp[curr%2][j] += dp[curr%2][j-1];
                }
            }
            curr = (curr + 1) % 2;
            prev = (curr + 1) % 2;
        }

        return dp[(prev%2)][n];
    }
}