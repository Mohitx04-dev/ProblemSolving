//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int nums1[], int nums2[], int len1, int len2, int k) {
        if(len1>len2) return kthElement(nums2,nums1,len2,len1,k);
        int low = 0;
        int high = Math.min(k,len1);
        if(len2<k) low=k-len2; 
        while(low<=high){
            int cut1 = ((low+high)>>1);
            int cut2 =  k - cut1;
            int l1 = (cut1<=0) ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = (cut2<=0) ? Integer.MIN_VALUE : nums2[cut2-1];
            int r1 = (cut1>=nums1.length) ?  Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2>=nums2.length) ?  Integer.MAX_VALUE : nums2[cut2];
            if(l1<=r2 && l2<=r1) {
                return Math.max(l1,l2);
            }
            else if(l1>r2) high = cut1-1;
            else low = cut1+1;
        }
        return 0;
    }
}