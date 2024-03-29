//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

 class Res
    {
        Node pre = null;
        Node succ = null;
    }
class PreSucc
{
   
     public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    
      public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t = sc.nextInt();
          
           while(t-->0){
            int n = sc.nextInt();
            if(n==0)
            {
                System.out.println(0);
                continue;
            }
            Node root = null;
           Res p = new Res();
           Res s = new Res();
            for(int i=0;i<n;i++){
                
                int a=sc.nextInt();
                int a1=sc.nextInt();
                
                char lr=sc.next().charAt(0);
                
                if(i==0){
                    
                    root=new Node(a);
                    
                    switch(lr)
                    {
                        
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            
            int key = sc.nextInt();
            GfG g=new GfG();
            g.findPreSuc(root, p, s, key);
            
            if(p.pre != null)
              System.out.print(p.pre.data + " ");
              else
              System.out.print("-1" + " ");
              
            if(s.succ != null)
              System.out.println(s.succ.data);
              else
              System.out.println("-1");
            
            
        }
    }
}
// } Driver Code Ends


/* BST Node
class Node
{
	int key;
	Node left, right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class GfG
{
    static Node pp;
    static Node ss;
    static int pv = Integer.MIN_VALUE;
    static int sv = Integer.MAX_VALUE;
    static void fun(Node root, int key) {
        if(root==null) return;
        if(root.data > pv && root.data < key) {
            pp = root;
            pv = root.data;
        }
        if(root.data < sv && root.data > key) {
            ss = root;
            sv = root.data;
        }
        if(key > root.data) fun(root.right, key);
        else if(key<root.data) fun(root.left, key);
        else {
            fun(root.right, key);
             fun(root.left, key);
        }
    }
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here\
       fun(root, key);
       if(pp!=null) {
          p.pre = pp;
          s.pre = pp;
       }
        if(ss!=null){
          s.succ = ss;
          p.succ = ss;
        }
        pv =  Integer.MIN_VALUE;
        sv = Integer.MAX_VALUE;
        pp = null;
        ss = null;
       
    }
}