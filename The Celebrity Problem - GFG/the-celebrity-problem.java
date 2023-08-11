//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class UF {
    int[] p;
    int[] s;
    public UF(int n) {
        this.p = new int[n];
        this.s = new int[n];
        for(int i=0;i<n;i++) {
            p[i] = i;
            s[i] = 1;
        }
    }
    void union(int i, int j) {
        i = findParent(i);
        j = findParent(j);
        if(i!=j) {
            if(s[i] > s[j]) {
                s[i]+=s[j];
                p[j]=i;
            }
            else {
                s[j]+=s[i];
                p[i]=j;
            }
        }
    }
    int findParent(int i) {
        if(p[i]==i) return i;
        else return findParent(p[i]);
    }
}
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here
    	int[] k = new int[n];
    	int[] nt = new int[n];
    	for(int i=0;i<n;i++) {
    	    for(int j=0;j<n;j++) {
    	        if(M[i][j]==1) {
    	            k[j]++;
    	        }
    	        else nt[i]++;
    	    }
    	}
    // 	System.out.println(Arrays.toString(k));
    // 	System.out.println(Arrays.toString(nt));
    	for(int i=0;i<n;i++){
    	    if(k[i]==n-1 && nt[i]==n) return i;
    	}
    	return -1;
    }
}