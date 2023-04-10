class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int no1=1,no2=2;
        for(int i=3;i<=n;i++)
        {
            int res = no1+no2;
            no1=no2;
            no2=res;
        }
        return no2;
    }
}