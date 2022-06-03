/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) {
            // if(n==1){
            //     return head;
            // }
            // else{
                return null;
            // }
        }
        ListNode x = head;
        int c = 0;
        while(x!=null) {
            c+=1;
            x = x.next;
        }
        if(c==n) {
            head = head.next;
            return head;
        }
        x = head;
        while(c-n>1) {
            c--;
            x = x.next;
        }
        x.next = x.next.next;
        return head;
    }
}