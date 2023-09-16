//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        HashSet<Integer> hs = new HashSet<Integer>();
        TreeSet<Integer> hs2 = new TreeSet<Integer>();
        for(int i : arr) {
            if(hs.contains(i)) hs2.add(i);
            hs.add(i);
        }
        if(hs2.size()==0) hs2.add(-1);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.addAll(hs2);
        return ans;
    }
}
