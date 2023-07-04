//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> stack = new Stack<>();
        long[] ans = new long[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            while(stack.size()>0 && stack.peek() <= arr[i])
            {
                stack.pop();
            }
            if(stack.size()==0) ans[i]=-1;
            else ans[i]=stack.peek();
            
            stack.push(arr[i]);
        }
        return ans;
        // Stack<Long> stack = new Stack<>();
        // long[] and = new long[arr.length];
        // stack.push(0);
        // for(int i=1;i<arr.length;i++){
        //     while(stack.size()>0 && arr[stack.peek()]<arr[i])
        //     {
        //         ans[stack.peek()]=arr[i];
        //         stack.pop();
        //     }
        //     stack.push(i);
        // }
        // while(stack.size()>0)
        // {
        //     ans[stack.pop]=-1;
        // }
        // return ans;
    } 
}