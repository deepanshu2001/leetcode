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
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode node=new ListNode(0);
        ListNode dummy=node;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                node.next=new ListNode(l1.val);
                l1=l1.next;
            }
            else{
                node.next=new ListNode(l2.val);
                l2=l2.next;
            }
            node=node.next;
        }
        while(l1!=null){
            node.next=new ListNode(l1.val);
            l1=l1.next;
            node=node.next;
        }
        while(l2!=null){
            node.next=new ListNode(l2.val);
            l2=l2.next;
            node=node.next;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode l1=lists[0];
        if(lists.length==1){
            return l1;
        }
        for(int i=1;i<lists.length;i++){
            ListNode l2=lists[i];
            l1=merge(l1, l2);
        }
        return l1;
    }
}