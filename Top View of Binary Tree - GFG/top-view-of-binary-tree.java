//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Location {
    int x;
    int y;
    Node node;
    public Location(Node t, int x, int y) {
        this.x = x;
        this.y = y;
        node = t;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
         Queue<Location> q = new LinkedList<Location>();
         PriorityQueue<Location> pq = new PriorityQueue<Location>((Location a, Location b) -> {
             if(a.x>b.x) return 1;
             else if(a.x<b.x) return -1;
             else if(a.y>b.y) return 1;
             else if(a.y<b.y) return -1;
             else if(a.node.data>=b.node.data) return 1;
             else if(a.node.data<b.node.data) return -1;
             else return 0;
         });
         q.add(new Location(root,0,0));
         while(!q.isEmpty()) {
             List<Location> l = new ArrayList<Location>();
             int n = q.size();
             for(int i=0;i<n;i++) {
                 Location node = q.poll();
                 pq.add(node);
                 if(node.node.left!=null) q.add(new Location(node.node.left, node.x-1, node.y+1));
                 if(node.node.right!=null) q.add(new Location(node.node.right, node.x+1, node.y+1));
             }
         } 
         ArrayList<Integer> ans = new ArrayList<Integer>();
         HashSet<Integer> hs = new HashSet<Integer>();
         while(!pq.isEmpty()) {
             Location ff = pq.poll();
             if(!hs.contains(ff.x)) {
                 ans.add(ff.node.data);
                 hs.add(ff.x);
             }
         }
         return ans;
    }
}