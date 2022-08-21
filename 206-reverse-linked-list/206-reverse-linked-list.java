class Solution {
    public ListNode reverseList(ListNode head) {
      
      
      if(head == null){
        return null;
      }
      return reverseNode(head,null);
    }
  
  private ListNode reverseNode(ListNode head, ListNode prev){
    if(head == null){
      return prev;
    }
    
    ListNode next = head.next;
    
    head.next = prev;
    return reverseNode(next,head);
  }
}