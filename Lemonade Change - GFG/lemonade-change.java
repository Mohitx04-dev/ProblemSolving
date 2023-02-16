//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
     int[] coins = new int[3];
     for(int i : bills) {
         switch(i){
            case 5:
                coins[0]++;
                break;
            case 10:
                if(coins[0]<1) return false;
                coins[0]-=1;
                coins[1]++;
                break;
            case 20:
                if(coins[1]>=1 && coins[0]>=1) {
                    coins[0]-=1;
                    coins[1]-=1;
                    coins[2]++;
                }
                else if(coins[0]>=3) {
                    coins[0]-=3;
                    coins[2]++;
                }
                else return false;
                break;
         }
     }
     return true;
    }
}
