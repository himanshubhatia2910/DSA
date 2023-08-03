class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0;
        int product=1;
        int no=0;
        while(n!=0)
        {
            no=n%10;
            sum+=no;
            product*=no;
            n=n/10;
        }
        return product-sum;
    }
}