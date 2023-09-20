class Solution {
   public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int target=sum-x;
        if(target<0) return -1;
         int left = 0;
        int len = -1;
        int currSum = 0;
        
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            
            while (currSum > target) {
                currSum -= nums[left];
                left++;
            }
            
            if (currSum == target) {
                len = Math.max(len, right - left + 1);
            }
        }
        if(len==-1) return -1;
        else return nums.length-len;
    }
}