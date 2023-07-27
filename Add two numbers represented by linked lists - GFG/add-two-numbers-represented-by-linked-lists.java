//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
       static Node reverse(Node l1) {
        Node cur = l1;
        Node prev = null;
        while(cur!=null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node l1, Node l2){
        // code here
        // return head of sum list
        Node n1 = reverse(l1);
        Node n2 = reverse(l2);
        Node i1 = n1;
        Node i2 = n2;
        Node ans = new Node(0);
        Node i = ans;
        int carry = 0;
        while(i1!=null && i2!=null) {
            int v = (i1.data + i2.data) + carry;
            // System.out.println(v);
            carry = v/10;
            i.next = new Node(v%10);
            // System.out.println(i.next.data);
            i = i.next;
            i1 = i1.next;
            i2 = i2.next;
        }
        while(i1!=null) {
            int v = i1.data + carry;
            carry = v/10;
            i.next = new Node(v%10);
            i = i.next;
            i1 = i1.next;
        }
        while(i2!=null) {
            int v = i2.data + carry;
            carry = v/10;
            i.next = new Node(v%10);
            i = i.next;
            i2 = i2.next;
        }
        if(carry>0) {
            i.next = new Node(carry);
            i = i.next;
            // i.data=carry;
        }
        return reverse(ans.next);
    }
}