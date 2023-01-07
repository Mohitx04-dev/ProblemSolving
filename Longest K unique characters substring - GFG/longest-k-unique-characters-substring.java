//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm = new HashMap<Character,Integer> ();
        int i=0,j=0;
        int max=-1;
        while(j<s.length()){
            char cy = s.charAt(j);
            if(hm.containsKey(cy)) hm.put(cy, hm.get(cy)+1);
            else hm.put(cy,1);
            if(hm.size()<k) j++;
            else if(hm.size()==k) {
                max = Math.max(max, j-i+1);
                j++;
            }
            else if(hm.size()>k) {
                while(hm.size()>k && i<s.length()){
                    if(hm.containsKey(s.charAt(i))){
                        int freq = hm.get(s.charAt(i));
                        if(freq==1) hm.remove(s.charAt(i));
                        else hm.put(s.charAt(i),freq-1);
                    } 
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}