//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution {
    long wineSelling(int Arr[],int N){
        int b = 0;
        int s = 0;
        long c = 0;
        // while(Arr[++b]<0);
        // while(Arr[++s]>0);
        while(b < N && s < N) {
            // System.out.println(Arrays.toString(Arr));
            if(Arr[b]<=0) {
                b++;
                continue;
            }
            if(Arr[s]>=0) {
                s++;
                continue;
            }
            if(b>=N || s>=N) break;
            if(Arr[b] > Math.abs(Arr[s])) {
                c += Math.abs(b-s) * Math.abs(Arr[s]);
                Arr[b] += Arr[s];
                Arr[s] = 0;
                s++;
            }
            else {
                c += Math.abs(b-s) * Math.abs(Arr[b]);
                Arr[s] += Arr[b];
                Arr[b] = 0;
                b++;
            }
        }
        return c;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends