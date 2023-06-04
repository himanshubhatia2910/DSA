class Solution {
    public int maxSubArray(int[] nums) {
        int current_Sum=0;
        int max_Sum=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            current_Sum = current_Sum+nums[i];
            max_Sum = Math.max(max_Sum, current_Sum);
            if(current_Sum<0) current_Sum=0;
        }
        
        return max_Sum;
    }
}