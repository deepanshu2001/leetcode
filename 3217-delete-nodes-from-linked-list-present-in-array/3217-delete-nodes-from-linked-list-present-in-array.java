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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        if(head==null){
            return head;
        }
        while(set.contains(head.val)){
            head=head.next;
        }
        ListNode node=head;
        while(node!=null && node.next!=null){
            if(set.contains(node.next.val)){
                node.next=node.next.next;
            }
            else{
                node=node.next;
            }
        }
        return head;
    }
}