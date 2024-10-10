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
        //creating the nodes
        if(head==null){
            return head;
        }
        Node node=head;
        while(node!=null){
            Node temp=node.next;
            node.next=new Node(node.val);
            node.next.next=temp;
            node=temp;
        }
        //creating random pointers
        node=head;
        while(node!=null){
            if(node.next!=null){
                node.next.random=node.random!=null?node.random.next:null;
            }
            node=node.next.next;
        }
        //getting the copyRandomList
        Node new_head=head.next;
        Node temp=new_head;
        node=head;
        while(node!=null){
            node.next=temp.next;
            if(node.next!=null){
              temp.next=node.next.next;
            }
            
            node=node.next;
            temp=temp.next;
            
        }
        return new_head;
    }
}