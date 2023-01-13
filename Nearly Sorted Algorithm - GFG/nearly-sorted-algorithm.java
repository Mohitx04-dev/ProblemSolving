/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static void fun(int[]arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((v,w)-> Integer.compare(v,w));
        int count=0;
        for(int x : arr) {
            pq.add(x);
            if(count>(arr.length-k+1)) break;
            if(pq.size()>k) arr[count++] = pq.poll();
            
        }
        while(!pq.isEmpty()) arr[count++] = pq.poll();
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0) {
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    fun(arr,k);
		    t--;
		}
	}
}