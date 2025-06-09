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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode new_head=head.next;
        ListNode o=head;
        ListNode e=head.next;
        while(o!=null && o.next!=null){
            o.next=e.next;
            e.next=o;
            dummy.next=e;
            dummy=o;
            o=o.next;
            if(o!=null){
                e=o.next;
            }
        }
        return new_head;
    }
}