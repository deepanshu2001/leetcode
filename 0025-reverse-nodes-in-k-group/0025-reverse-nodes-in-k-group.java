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
    public int getLen(ListNode head){
        int len=0;
        ListNode node=head;
        while(node!=null){
            len++;
            node=node.next;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int len=getLen(head);
        if(head==null||len<k){
            return head;
        }
        int cnt=len/k;
        ListNode current=head;
        ListNode prev=null;
        while(cnt>0){
            ListNode last=prev;
            ListNode new_end=current;
            ListNode next=current.next;
            for(int i=0;current!=null &&i<k;i++){
                current.next=prev;
                prev=current;
                current=next;
                if(next!=null){
                    next=next.next;
                }
            }
            if(last!=null){
               last.next=prev;
            }
            else{
                head=prev;
            }
            new_end.next=current;
            prev=new_end;
            cnt--;
        }
        return head;

    }
}