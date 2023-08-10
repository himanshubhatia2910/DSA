class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]= new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            int new_target= target-nums[i];
            if(map.containsKey(new_target)==true)
            {
                ans[0]=map.get(new_target);
                ans[1]=i;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}