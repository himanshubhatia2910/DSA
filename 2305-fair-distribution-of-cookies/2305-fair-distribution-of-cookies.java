class Solution {
  private int res=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
       backtracking(cookies,0,k,new int[k]);
       return res;
    }
 void backtracking(int[] cookies,int index,int k,int[] cookiesdistribution){
         if(index==cookies.length)  {
             int max=0;
             for(int cook: cookiesdistribution)  max=Math.max(max,cook);
                
                 res=Math.min(res,max);
                 return;
             
         }
         for(int i=0;i<k;i++){
             cookiesdistribution[i]+=cookies[index];
             backtracking(cookies,index+1,k,cookiesdistribution);
             cookiesdistribution[i]-=cookies[index];
         }

    }
}