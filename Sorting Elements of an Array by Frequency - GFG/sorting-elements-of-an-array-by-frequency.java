//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class Driverclass 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			 ArrayList<Integer> ans = new ArrayList<Integer>();
			 ans = new Solution().sortByFreq(arr, size);
			 for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
		    System.out.println();
			n--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to sort the array according to frequency of elements.
    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->{
            if(hm.get(a)!=hm.get(b)) return hm.get(b)-hm.get(a);
            else return a-b;
        });
        for(int i : arr) hm.put(i,hm.getOrDefault(i,0)+1);
        for(int i : hm.keySet()) pq.add(i);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(!pq.isEmpty()) {
            int el = pq.poll();
            int t = hm.get(el);
            while(t-->0)  ans.add(el);
        }
        return ans;
    }
}