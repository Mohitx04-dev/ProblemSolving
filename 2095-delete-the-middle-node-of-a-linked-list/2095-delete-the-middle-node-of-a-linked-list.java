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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            return null;
        }
        int count = 0; 
        ListNode temp = head;
        while(temp.next!=null) {
            temp = temp.next;
            count++;
        }
        temp = head;
        int m = count;
        while(m>(count/2)+1) {
            temp = temp.next;
            m--;
        }
        System.out.println(temp.val);
        ListNode x = temp.next.next;
        temp.next = x;
        return head;
    }
}