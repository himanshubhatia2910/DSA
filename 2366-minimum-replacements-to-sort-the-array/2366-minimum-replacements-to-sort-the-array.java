class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long ans =0;
        long prev =nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            long parts = nums[i]/prev;
            if((nums[i])%prev!=0)
            {
                parts++;
                prev=nums[i]/parts;
            }
            ans+=parts-1;
        }
        return ans;
    }
}