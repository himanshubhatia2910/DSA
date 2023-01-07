//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    static int evenlyDivides(int N){
        int count=0;
        int divisor= N;
        int remainder=0;
        while(N!=0){
            remainder = N%10;
            if(remainder!=0)
            {
                if(divisor%remainder==0)
                {
                    count++;
                }
            }
            N=N/10;
        }
        return count;
    }
}