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
    ListNode node;
    public void f(ListNode head,ListNode prev){
        if(head==null){
            node=prev;
            return;
        }
        f(head.next,head);
        head.next=prev;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        f(head,null);
        head=node;
        return head;
    }
}