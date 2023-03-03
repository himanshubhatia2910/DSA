class Solution {
    public int differenceOfSum(int[] nums) {
        int sum=0,digitSum=0,extract=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            while(nums[i]!=0)
            {
                extract = nums[i]%10;
                digitSum+=extract;
                nums[i]=nums[i]/10;
            }
        }
        return Math.abs(sum-digitSum);
    }
}