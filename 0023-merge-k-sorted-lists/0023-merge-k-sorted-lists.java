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
        int size=0;
        List<Integer> nodes=new ArrayList<>();
        for(ListNode list:lists){
           while(list!=null){
            nodes.add(list.val);
            list=list.next;
           }
        }
        Collections.sort(nodes);
        ListNode node=new ListNode(0);
        ListNode temp=node;
        for(int num:nodes){
            temp.next=new ListNode(num);
            temp=temp.next;
        }
        return node.next;
    }
}