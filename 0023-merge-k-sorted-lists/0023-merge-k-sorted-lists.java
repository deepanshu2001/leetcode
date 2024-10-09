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
        List<Integer> l=new ArrayList<>();
        for(ListNode k:lists){
            while(k!=null){
                l.add(k.val);
                k=k.next;
            }
        }
        Collections.sort(l);
        ListNode dummy=new ListNode(0);
        ListNode node=dummy;
        for(int i=0;i<l.size();i++){
            node.next=new ListNode(l.get(i));
            node=node.next;
        }
        return dummy.next;
    }
}