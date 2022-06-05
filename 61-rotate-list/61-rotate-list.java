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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode itr = head;
        if(itr==null || itr.next==null){
            return head;
        }
        if(itr.next.next==null){
            if(k%2==0) {
                return itr;
            }
            else{
                itr = itr.next;
                head.next = null;
                itr.next = head;
                head = itr;
                return head;
            }
        }
        int c = 0;
        while(itr.next!=null){
            itr = itr.next;
            c++;
        }
        c++;
        itr.next = head;
        itr = head;
        if(k>=c){
         k = k%c;
        }
        int t = 0;
            while(t<(c-k-1)) {
            itr = itr.next;
            t++;
            } 
            head = itr.next;
            itr.next = null;
        return head;
    }
}