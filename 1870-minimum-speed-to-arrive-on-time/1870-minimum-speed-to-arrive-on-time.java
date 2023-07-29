class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low=1,high=(int)1e7;
        int res=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(help(dist,hour,mid))
            {
                res=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return res;
    }
    public boolean help(int[] dist,double hour,int k)
    {
        double res=0;
        int n=dist.length;
        for(int i=0;i<n-1;i++)
        {
            double temp=(double)dist[i]/(double)k;
            res+=Math.ceil(temp);
        }
        res+=(double)dist[n-1]/(double)k;
        return res<=hour;
    }
}