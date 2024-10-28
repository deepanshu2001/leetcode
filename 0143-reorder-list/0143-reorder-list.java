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
    public ListNode getMid(ListNode head){
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int len=length/2;
        temp=head;
        ListNode curr=head;
        while(len>0){
            curr=temp;
            temp=temp.next;
            len--;
        }
        curr.next=null;
        return temp;
    }
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=curr.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
        }
        head=prev;
        return head;
    }
    public void reorderList(ListNode head) {
        if(head==null ||head.next==null){
            return;
        }
        ListNode mid=getMid(head);
        ListNode temp2=reverse(mid);
        ListNode temp1=head;
        ListNode dummy=new ListNode(0);
        
        ListNode node=dummy;
        while(temp1!=null||temp2!=null){
            if(temp1!=null){
               node.next=temp1;
               node=node.next;
               temp1=temp1.next;
            }
            if(temp2!=null){
               node.next=temp2;
               node=node.next;
               temp2=temp2.next;
            }
        }
        head=dummy.next;
    }
}