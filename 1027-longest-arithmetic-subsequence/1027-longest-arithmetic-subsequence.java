class Solution {
     public int longestArithSeqLength(int[] nums) {
        int n = nums.length;

        int[] max = new int[n];
        Arrays.fill(max, 1);
        int[][] dp = new int[n][1001];
        for(int[] d : dp) Arrays.fill(d, 1);

        for(int i = n - 2; i >= 0; i--) {
            // consider the case where i is included
            for(int j = i + 1; j < n; j++) {
                int diff = nums[i] - nums[j];
                // might have seen the same combination of (i, diff + 500) before
                dp[i][diff + 500] = Math.max(dp[i][diff + 500], 1 + dp[j][diff + 500]);
                max[i] = Math.max(max[i], dp[i][diff + 500]);
            }
            
            // consider the case where i is excluded
            max[i] = Math.max(max[i], max[i + 1]);
        }

        return max[0];
    }
}