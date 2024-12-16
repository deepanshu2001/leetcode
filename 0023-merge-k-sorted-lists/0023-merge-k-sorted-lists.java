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
        ListNode head=new ListNode(0);
        ListNode node=head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                node.next=new ListNode(l1.val);
                node=node.next;
                l1=l1.next;
            }
            else{
                node.next=new ListNode(l2.val);
                node=node.next;
                l2=l2.next;
            }
        }
        while(l1!=null){
            node.next=new ListNode(l1.val);
            node=node.next;
            l1=l1.next;
        }
        while(l2!=null){
            node.next=new ListNode(l2.val);
            node=node.next;
            l2=l2.next;
        }
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1){
            return lists[0];
        }
        if(lists.length==0){
           return null;
        }
        ListNode h1=lists[0];
        ListNode h2=lists[1];
        ListNode head=merge(h1,h2);
        for(int i=2;i<lists.length;i++){
            head=merge(head,lists[i]);
        }
        return head;
    }
}