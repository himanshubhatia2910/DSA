class Solution {
    public int[] countBits(int n) {
        int[] A = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            int p=i,count=0;
            while(p!=0)
            {
                if(p%2==1)
                {
                    count++;
                }
                p=p/2;
            }
            A[i]=count;
        }
        return A;
    }
}