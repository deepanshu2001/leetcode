/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean nocyle(ListNode head){
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
            if(s==f){
                return true;
            }
        }
        return false;
    }
    public ListNode detectCycle(ListNode head) {
       if(!nocyle(head)){
        return null;
       }
       ListNode s=head;
       ListNode f=head;
       do{
        s=s.next;
        f=f.next.next;
       }while(s!=f);
       s=head;
       while(s!=f){
        s=s.next;
        f=f.next;
       }
       return s;
    }
}