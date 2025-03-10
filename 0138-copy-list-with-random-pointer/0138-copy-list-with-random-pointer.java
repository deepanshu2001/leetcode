

import static java.lang.Math.random;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node node=head;
        while(node!=null){
            Node next_node=node.next;
            node.next=new Node(node.val);
            node.next.next=next_node;
            node=next_node;
        }
        node=head;
        while(node!=null && node.next!=null){
           if(node.random!=null){
              node.next.random=node.random.next;
           }
          
           if(node.next!=null){
            node=node.next.next;
           }
        }
        Node orig=head;
        Node copy=head.next;
        Node dummy=copy;
        while(orig!=null){
           orig.next=copy.next;
           if(orig.next!=null){
            copy.next=orig.next.next;
           }
           orig=orig.next;
           copy=copy.next;
        }
        return dummy;
    }
}