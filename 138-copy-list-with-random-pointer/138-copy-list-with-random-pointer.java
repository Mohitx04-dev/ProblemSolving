/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
      Node t1 = head;
      while(t1!=null) {
         Node x = new Node(t1.val);
         x.next = t1.next;
         t1.next = x;
         t1 = t1.next.next;
      }
      t1 = head;
      while(t1!=null) {
          if(t1.random!=null) t1.next.random = t1.random.next;
          t1 = t1.next.next;
      }
      t1=head;
      Node f = new Node(0);
      Node t2 = f;
      while(t1!=null){
          Node t = t1.next.next;
          t2.next = t1.next;
          t1.next = t;
          t1 = t;
          t2 = t2.next;
      }
      return f.next;
      
    }
}