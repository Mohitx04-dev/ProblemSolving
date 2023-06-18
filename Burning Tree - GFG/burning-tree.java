//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    static HashSet<Node> vis;
    static HashMap<Node,Node> parent;
    static int max;
    static void dfs(Node n, Node p, int k) {
        if(n==null) return;
        vis.add(n);
        if(n.left==null && n.right==null) {
            max = Math.max(max,k);
        }
        if(n.left!=null && n.left!=p && !vis.contains(n.left)) dfs(n.left,n,k+1);  
        if(n.right!=null && n.right!=p && !vis.contains(n.right)) dfs(n.right,n,k+1); 
        if(!vis.contains(parent.get(n))) dfs(parent.get(n),n,k+1);
    }
    public static int minTime(Node root, int target) 
    {
        
        max = 0;
        // Your code goes here
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node t = null;
        vis = new HashSet<Node>();
        parent = new HashMap<Node,Node>();
        while(!q.isEmpty()) {
           Node n = q.poll();
           if(n.data==target) t = n;
           if(n.left!=null) {
               parent.put(n.left,n);
               q.add(n.left);
           }
           if(n.right!=null) {
               parent.put(n.right,n);
               q.add(n.right);
           }
        }
        
        dfs(t,null,0);
        return max;
    }
}