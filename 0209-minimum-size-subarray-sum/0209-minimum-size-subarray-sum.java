class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int min_size=Integer.MAX_VALUE;
        int i=0,j=0;
        
        while(j<nums.length)
        {
            sum+=nums[j];
            while(sum>=target)
            {
                min_size= Math.min(min_size,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return min_size==Integer.MAX_VALUE?0:min_size;
    }
        
}