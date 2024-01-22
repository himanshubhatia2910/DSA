class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int sum=0;
        int duplicate = 0;
        for(int i: nums)
        {
            if(s.contains(i))
            {
                duplicate=i;
            }
            else{
                sum+=i;
                s.add(i);
            }
        }
        int total_sum = nums.length*(nums.length+1)/2;
        int ans[] = new int[2];
        ans[0]=duplicate;
        ans[1]= total_sum-sum;
        return ans;
    }
}