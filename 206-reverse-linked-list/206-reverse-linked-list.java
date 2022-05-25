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
    public ListNode reverseList(ListNode head) {
        ListNode next = new ListNode();
        ListNode prev = new ListNode();
        if(head==null || head.next==null) {
            return head;
        }
        prev = head;
        head = head.next;
        if(head.next==null) {
            prev.next = null;
            head.next = prev;
            return head;
        }
        int flag = 0;
        while(head.next!=null) {
            next = head.next;
            if(flag==0){
                prev.next = null;
                flag++;
            }
            head.next = prev;
            prev = head;
            head = next;
            System.out.println(prev.val+ " "+prev.next.val);
        }
        head.next = prev;
        System.out.println(head.val+ " "+head.next.val);
        return head;
    }
}