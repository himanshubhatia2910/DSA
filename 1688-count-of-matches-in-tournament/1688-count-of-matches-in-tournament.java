class Solution {
    public int numberOfMatches(int n) {
        int sum=0;
        
        while(n!=1)
        {
            if(n%2!=0)
            {
                sum+=n/2;
                n=n-(n/2);
            }
            else{
                sum+=n/2;
                n=n/2;
            }
        }
        return sum;
    }
}