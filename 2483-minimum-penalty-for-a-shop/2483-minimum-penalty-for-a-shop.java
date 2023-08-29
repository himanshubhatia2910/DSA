class Solution {
      public int bestClosingTime(String customers) {
        int n= customers.length();
        int count=0; //count panility at 0th hour;
        
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y')count++;
        }
        int ith_penalty=count;
        int j=0; // this point to the earliest hour of closing shop;
        int ans=ith_penalty;
        for(int i=1;i<=n;i++){
            if(customers.charAt(i-1)=='Y'){
                ith_penalty--;
            }
            else ith_penalty++;
            if(Math.min(ith_penalty,ans)<ans) j=i;
            ans=Math.min(ith_penalty,ans);
        }
        return j;
    }
}