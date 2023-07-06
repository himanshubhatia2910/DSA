class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE,  sum = 0, j=0;
        for(int i=0; i<nums.length; ){
            sum+=nums[i++];
            while(sum>=target){
              res = Math.min(res, i-j);
              sum-=nums[j++];
            }
        }
        return res==Integer.MAX_VALUE ? 0 : res;
    }
        
}