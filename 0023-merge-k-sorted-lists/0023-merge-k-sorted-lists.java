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
    public ListNode mergeKLists(ListNode[] lists) {
        int min_index=0;
        ListNode node=new ListNode(0);
        ListNode temp=node;
        boolean isBreak=true;
        while(true){
            isBreak=true;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null){
                    if(lists[i].val<min){
                      min_index=i;
                      min=lists[i].val;
                      isBreak=false;
                    }
                }
            }
            if(isBreak){
                break;
            }
            temp.next=new ListNode(min);
            temp=temp.next;
            lists[min_index]=lists[min_index].next;
        }
        return node.next;
    }
}