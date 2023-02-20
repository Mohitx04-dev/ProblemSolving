//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Pair {
    public String s;
    public int step;
    public Pair(String s, int step) {
        this.s = s;
        this.step = step;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> hs = new HashSet<String>();
        for(String t : wordList) hs.add(t);
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(startWord,1));
        while(!q.isEmpty()) {
            Pair p = q.poll();
            String s = p.s;
            if(s.equals(targetWord)) return p.step;
            char[] sa = s.toCharArray();
            for(int i=0;i<sa.length;i++) {
                for(int j=0;j<26;j++) {
                    char t = sa[i];
                    sa[i] = (char)(j+'a');
                    String temp = new String(sa);
                    if(hs.contains(temp)){
                        q.add(new Pair(temp,p.step+1));
                        hs.remove(new String(sa));
                    }
                    sa[i] = t;
                }
            }
        }
        return 0;
    }
}