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
        // Your code here
        int[] freq = new int[26];
        int m = 0;
        char a = 'z';
        for(char t : line.toCharArray()){
             freq[t-'a']++;
             if(m==freq[t-'a'] && t<a) a = t;
             else if(m < freq[t-'a']) {
                 m = freq[t-'a'];
                 a = t;
             }
        }
        return a;
    }
    
}