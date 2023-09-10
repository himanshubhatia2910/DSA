class Solution {
   int m=(int)1e9+7;
    public int solve(int i, int n, int prevans){
        if(i>n) return prevans;
        int spaces=2*(i-1)+1; 
       
        long curans=spaces*(spaces+1)/2;
      
        curans=curans*prevans;
        curans=curans%m;
        return solve(i+1,n,(int)curans);
    }
    public int countOrders(int n) {
        return solve(1,n,1);
        
    }
}