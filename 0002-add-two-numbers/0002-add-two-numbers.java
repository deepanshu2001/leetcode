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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode node=dummy;
        int carry=0;
        while(l1!=null||l2!=null||carry==1){
            int val=0;
            if(l1!=null){
                val+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val+=l2.val;
                l2=l2.next;
            }
            if(carry==1){
                val++;
                carry=0;
            }
            if(val==10){
                carry=1;
                val=0;
            }
            if(val>10){
                val=val%10;
                carry=1;
            }
            node.next=new ListNode(val);
            node=node.next;
        }
        return dummy.next;
    }
}