class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            int new_target = target - nums[i];
            if(mp.containsKey(new_target)==true)
            {
                ans[0] = mp.get(new_target);
                ans[1] = i; 
            }
            mp.put(nums[i],i);
        }
        return ans;
    }
}