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
    public int getDecimalValue(ListNode head) {
        String ans = Integer.toString(head.val);
        while(head.next!=null) {
            head = head.next;
            ans+=Integer.toString(head.val);
        }
        System.out.println(ans);
        int and = Integer.parseInt(ans,2);
        return and;
    }
}