class Solution {
    private static final int mod = 1_000_000_000 + 7;
    private int[][] dp;

    public int countPaths(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        
        long count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                count = (count + dfs(i, j, grid)) % mod;
            }
        }

        return (int)count;
    }

    private int dfs(int i, int j, int[][] grid) {
        if(dp[i][j] > 0) return dp[i][j];

        long count = 1;
        int[][] adjacents = new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};

        for(int[] adj : adjacents) {
            int m = adj[0], n = adj[1];
            if(m < 0 || m >= grid.length || n < 0 || n >= grid[0].length) continue;
            if(grid[m][n] <= grid[i][j]) continue;
            count = (count + dfs(m, n, grid)) % mod;
        }

        dp[i][j] = (int) count;
        return dp[i][j];
    }
}