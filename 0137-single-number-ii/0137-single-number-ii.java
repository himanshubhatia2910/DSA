class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int left=0,right= nums.length-1;
        
        while(left<right)
        {
            if(nums[left]==nums[left+1]) left+=3;
            if(nums[right]==nums[right-1]) right-=3;
        }
        return nums[left];
    }
}