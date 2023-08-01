class Solution {
    public boolean PredictTheWinner(int[] nums) {

        int n=nums.length;


       return optimal(nums,0,nums.length-1,new Integer[n+1][n+1])>=0;

        
    }

    public int  optimal(int []nums,int low,int hi,Integer[][]dp){

        if(low>hi){

            return 0;
        }

        if(low==hi){

            return nums[low];
        }

        if(dp[low][hi]!=null){

            return dp[low][hi];
        }

        int s1=nums[low]-optimal(nums,low+1,hi,dp);

        int s2=nums[hi]-optimal(nums,low,hi-1,dp);

        return dp[low][hi]=Math.max(s1,s2);

    }
}