//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends
class DisjointSet {
    public int[] p;
    public int[] size;
    public DisjointSet(int n){
        p = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++) p[i] = i;
        Arrays.fill(size,1);
    }
    public int findParent(int n) {
        if(p[n]==n) return n;
        else return p[n] = findParent(p[n]);
    }
    public void Union(int i, int j) {
        int a = findParent(i);
        int b = findParent(j);
        if(a==b) return;
        else if(size[a]>=size[b]) {
            size[a]+=size[b];
            p[b] = a;
        } 
        else {
            size[b]+=size[a];
            p[a] = b;
        }
    }
}

class Solution {
    int maxRemove(int[][] stones, int n) {
      int r=0;
        int c=0;
        for(int[] x : stones) {
            r = Math.max(r,x[0]);
            c = Math.max(c,x[1]);
        }
        DisjointSet d = new DisjointSet(r+c+2);

        int ans=0;
        int[] arr = d.p.clone();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int [] x: stones) {
           hm.put(x[0],1);
           hm.put(x[1]+r+1,1);
           d.Union(x[0],x[1]+r+1);
        }
        for(Integer t : hm.keySet()) if(d.findParent(t)==t) ans+=1;
        return stones.length-ans;
    }
};
