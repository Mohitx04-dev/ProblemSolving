//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    static PriorityQueue<Integer> max = new PriorityQueue<Integer>();
    static PriorityQueue<Integer> min = new PriorityQueue<Integer>((a,b)->b-a);
    public static void insertHeap(int x)
    {
        // add your code here
        if(min.size()==max.size()) {
            min.add(x);
            max.add(min.poll());
        }
        else {
            max.add(x);
            min.add(max.poll());
        }
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
       
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        if(min.size()==max.size()) return (min.peek()+max.peek())/2;
        else return max.peek();
        // add your code here
    }
    
}