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
        ListNode temp=null;
        ListNode prev=null;
        ListNode curr=head;
        int cnt=1;
        while(cnt!=left){
            cnt++;
            prev=curr;
            curr=curr.next;
        }
        temp=prev;
        ListNode t1=curr;
        ListNode next=curr.next;
        for(int i=left;i<=right;i++){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
        }
        if(temp!=null){
          temp.next=prev;
        }
        
        t1.next=curr;
        if(left==1){
            head=prev;
        }
        return head;
    }
}