//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(array, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int missingNumber(int array[], int n) {
         /* Brute Force Approach:
        int missing=0;
        Arrays.sort(array);
        for(int i=0;i<array.length-1;i++)
        {
            if(array[i+1]-array[i]>1) missing=array[i]+1;
        }
        return missing;*/
        
        //Optimised Approach:
        int sum=0;
        int totalSum= n*(n+1)/2;
        for(int i=0;i<array.length;i++)
        {
            sum+=array[i];
        }
        return totalSum-sum;
    }
}