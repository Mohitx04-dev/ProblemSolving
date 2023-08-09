//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    int res = ob.findNext(n);
                    if(res==-1)
                        System.out.println("not possible");
                    else
                        System.out.println(res);
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    void swap(char[] arr,int i, int j) {
        char x = arr[j];
        arr[j] = arr[i];
        arr[i] = x;
    }
    public int findNext (int n) 
    {
        // your code here
        String s = Integer.toString(n);
        char[] arr = s.toCharArray();
        boolean found = false;
        for(int i=arr.length-2;i>=0;i--) {
            if(arr[i] < arr[i+1]) {
                for(int j=arr.length-1;j>=i;j--){
                    if(arr[j]>arr[i]) {
                        swap(arr,i,j);
                        int a = i+1;
                        int b = arr.length-1;
                        while(a<b) swap(arr,a++,b--);
                        return Integer.parseInt(new String(arr));
                    }
                }
            }
        }
        return -1;
    }

}