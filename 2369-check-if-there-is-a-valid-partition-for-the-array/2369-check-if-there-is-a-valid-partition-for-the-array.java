class Solution {
   public boolean validPartition(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return f(n-1, nums, dp);
    }

    private boolean f(int i, int[] nums, Boolean[] dp){
        if (i < 0)
            return true;
        if (dp[i] != null)
            return dp[i];
        
        boolean equal2 = false, equal3 = false, increasing3 = false;
        if (i > 0 && nums[i] == nums[i-1])
            equal2 = f(i-2, nums, dp);
        if (i > 1 && nums[i] == nums[i-1] && nums[i] == nums[i-2])
            equal3 = f(i-3, nums, dp);
        if (i > 1 && nums[i] == nums[i-1] + 1 && nums[i-1] == nums[i-2] + 1)
            increasing3 = f(i-3, nums, dp);
        return dp[i] = equal2 || equal3 || increasing3;
    }
}