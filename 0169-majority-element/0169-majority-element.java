class Solution {
    public int majorityElement(int[] nums) {
       int candidate = nums[0];
       int count=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==candidate) count++;
            else count--;
            
            if(count==0){
                candidate = nums[i];
                count=1;
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==candidate) count++;
        }
        if(count>nums.length/2) return candidate;
        else return -1;
    }
}