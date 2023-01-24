//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        int sum=0,remainder=0,product=0,no=n;
        String str1="Yes",str2="No";
        while(n>0)
        {
            remainder=n%10;
            product=(remainder*remainder*remainder);
            sum=sum+product;
            n=n/10;
        }
        if(sum==no)
        {
            return str1;   
        }
        else
        {
            return str2;
        }
    }
}