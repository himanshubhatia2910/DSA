class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        stack.push(0);
        for(int i=1;i<2*n;i++)
        {
            while(stack.size()>0 && nums[stack.peek()]<nums[i%n])
            {
                ans[stack.pop()]=nums[i%n];
            }
            stack.push(i%n);
        }
        return ans;
    }
}