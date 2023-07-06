class Solution {
      public int longestSubarray(int[] nums) {
          int ZeroCount=0;
          int LongestWindow=0;
          
          int start=0;
          
          for(int i=0;i<nums.length;i++)
          {
              ZeroCount+=nums[i]==0?1:0;
                while(ZeroCount>1)
                {
                    ZeroCount-=nums[start]==0?1:0;
                    start++;
                }
              LongestWindow = Math.max(LongestWindow,i-start);
          }
          return LongestWindow;
      }
}