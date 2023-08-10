class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        map.put(0,1);
        int ans=0;
        int psum=0;
        for(int i=0;i<nums.length;i++)
            {
                psum+=nums[i];
                if(map.containsKey(psum-k)==true)
                {
                    ans+=map.get(psum-k);
                }
                map.put(psum,map.getOrDefault(psum,0)+1);
            }
        return ans;
    }
}