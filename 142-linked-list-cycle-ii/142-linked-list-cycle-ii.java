/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        if(head==null || head.next == null){
            return null;
        }
        while(f.next!=null && f.next.next!=null && s.next!=null ){
            s = s.next;
            f = f.next.next;
            if(s==f){
              f=head;
              while(f!=s){
                  s = s.next;
                  f = f.next;
              }
              return f;
            }
        }
        return null;

    }
}