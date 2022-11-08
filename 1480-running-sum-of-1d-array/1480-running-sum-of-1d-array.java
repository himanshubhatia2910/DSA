class Solution {
    public int[] runningSum(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length-1;i++)
        {
            sum=nums[i]+nums[i+1];
            nums[i+1]=sum;
            sum=0;
        }
        return nums;
    }
}