class Solution {
    public int numberOfSteps(int num) {
        int c1=0;
        while(num!=0)
        {
            if(num%2==0)
            {
                num=num/2;
                c1++;
            }
            else
            {
                num=num-1;
                c1++;
            }
            
        }
        return c1;
    }
}