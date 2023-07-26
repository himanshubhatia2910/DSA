//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
       int count[]= new int[256];
       for(char ch: line.toCharArray())
       {
           count[ch]++;
       }
       int maxCount=Integer.MIN_VALUE;
       char maxChar='\0';
       
       for(int i=0;i<count.length;i++)
       {
           if(count[i]>maxCount)
           {
               maxCount=count[i];
               maxChar=(char)i;
           }
       }
       return maxChar;
    }
    
}