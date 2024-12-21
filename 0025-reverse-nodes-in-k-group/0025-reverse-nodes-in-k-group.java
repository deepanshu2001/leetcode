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
    public int getLength(ListNode node){
       int len=0;
       while(node!=null){
        len++;
        node=node.next;
       }
       return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        int len=getLength(head);
        if(len<k){
            return head;
        }
        int cnt=len/k;
        ListNode curr=head;
        ListNode prev=null;
        while(cnt>0){
            ListNode last=prev;
            ListNode new_end=curr;
            ListNode next=curr.next;
            for(int i=0;curr!=null && i<k;i++){
                curr.next=prev;
                prev=curr;
                curr=next;
                if(next!=null){
                    next=next.next;
                }
            }
            if(last==null){
                head=prev;
            }
            else{
                last.next=prev;
            }
            cnt--;
            new_end.next=curr;
            prev=new_end;
        }
        return head;
    }
}