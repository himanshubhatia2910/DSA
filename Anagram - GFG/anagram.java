//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    static int NO_OF_CHARS=256;
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        /* Using Count Array */
        // if(a.length()!=b.length())
        // {
        //     return false;
        // }
        // int count[] = new int[NO_OF_CHARS];
        
        // char str[] = a.toCharArray();
        // char str1[] = b.toCharArray();
        // for(int i=0;i<a.length();i++)
        // {
        //     count[str[i]]++;
        //     count[str1[i]]--;
        // }
        // for(int i=0;i<NO_OF_CHARS;i++)
        // {
        //     if(count[i]!=0) return false;
        // }
        // return true;
        
        /*Using Sorting*/
        if(a.length()!=b.length())
        {
            return false;
        }
        char str[] = a.toCharArray();
        char str1[] = b.toCharArray();
        
        Arrays.sort(str);
        Arrays.sort(str1);
    
        for(int i=0;i<a.length();i++)
        {
            if(str[i]!=str1[i]) return false;
        }
        return true;
    }
}