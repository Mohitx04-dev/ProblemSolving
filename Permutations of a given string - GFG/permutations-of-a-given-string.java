//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    List<String> ans;
    void fun(String t, String S, int[] vis) {
        if(t.length()==S.length()) {
            if(!ans.contains(t)) ans.add(new String(t));
            return;
        }
        for(int i=0;i<S.length();i++) {
            if(vis[i]==1) continue;
            t+=S.charAt(i);
            vis[i] = 1;
            fun(t,S,vis);
            t=t.substring(0,t.length()-1);
            vis[i] = 0;
        }
    }
    public List<String> find_permutation(String S) {
        // Code here
       ans = new ArrayList<String>();
       fun(new String(),S,new int[S.length()]);
       Collections.sort(ans);
       return ans;
    }
}