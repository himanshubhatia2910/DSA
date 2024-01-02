class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++)
        {
            List<Integer> temp = new ArrayList<>();
            if(nums[i]!=0)
            {
                temp.add(nums[i]);
            }
            for(int j=i+1;j<nums.length;j++)
            {
                if(temp.contains(nums[j])) continue;
                
                if(nums[i]!=nums[j] && nums[j]!=0)
                {
                    temp.add(nums[j]);
                    nums[j]=0;
                }
            }
            if(!temp.isEmpty())
            {
                ans.add(temp);
            }
        }
        return ans;
    }
}