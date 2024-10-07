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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp=new ListNode(0);
        temp.next=head;
     
        ListNode new_head=temp;
        int l_index=0;
        while(l_index<left-1){
           l_index++;
           temp=temp.next;
        }
        ListNode n=temp.next;
        ListNode node=null;
        ListNode prev=null;
        l_index=left;
        while(l_index<=right && n!=null){
            node=n.next;
            n.next=prev;
            prev=n;
            n=node;
            l_index++;
        }
        ListNode t=temp.next;
        temp.next=prev;
        t.next=n;
        if(left==1){
           return new_head.next;
        }
        return head;
    }
}