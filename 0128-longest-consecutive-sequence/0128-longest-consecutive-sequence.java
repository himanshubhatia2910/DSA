class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0){return 0;}
        HashMap<Integer,Boolean> map = new HashMap<>();
        
        // 1.Assuming all elements as valid Starting point.
        
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],true);
        }
        
        //2.Checking for Valid Starting points.
        
          for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]-1)==true)
            {
                map.put(nums[i],false);
            }
        }
        
        // Finding length of longest sequence for valid starting point.
        
        int maxLen=1;
        for(int i=0;i<nums.length;i++)
        {
            if(map.get(nums[i])==true)
               {
                   int currlen=1;
                   int val=nums[i];
                   while(map.containsKey(val+1)==true)
                   {
                       currlen++;
                       val++;
                   }
                   maxLen=Math.max(currlen,maxLen);
               }
        }
        return maxLen;
    }
}