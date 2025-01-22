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
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
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
        if(head==null||head.next==null){
            return;
        }
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        f=head;
        while(f.next!=s){
            f=f.next;
        }
        f.next=null;
        ListNode t2=reverse(s);
        ListNode temp=head;
        ListNode t1=head.next;
        while(t1!=null||t2!=null){
            if(t2!=null){
                temp.next=new ListNode(t2.val);
                t2=t2.next;
                temp=temp.next; 
            }
            if(t1!=null){
                temp.next=new ListNode(t1.val);
                temp=temp.next;
                t1=t1.next;
            }
        }
    }
}