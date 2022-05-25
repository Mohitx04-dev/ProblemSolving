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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode x = new ListNode(head.val, head.next);
        while(head.next!=null) {
            count++;
            head = head.next;
        }
        int c = count;
        while(c>(count/2)){
            c--;
            x = x.next;
        }
        return x;
    }
}