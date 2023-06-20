class Solution {
    public int[] getAverages(int[] nums, int k) 
    {
        int diameter=(2*k)+1;

        int ans[]= new int [nums.length];
        Arrays.fill(ans,-1);

        if(k>nums.length)
        {
            return ans;
        }

        int start=0;
        int end=0;
        long sum=0;

        while(start<=end && end<nums.length)
        {
            //compression
            while(end-start+1>diameter)
            {
                sum-=nums[start];
                start++;
            }
            //Expanding
            if(end-start+1 <=diameter)
            {
                sum+=nums[end];
            }
            //Calculation
            if(end-start+1 == diameter)
            {
                int mid=start+(end-start)/2;

                if(mid<nums.length) ans[mid]=(int)(sum/diameter);

            }
            end++;
        }
        return ans;
    }
}