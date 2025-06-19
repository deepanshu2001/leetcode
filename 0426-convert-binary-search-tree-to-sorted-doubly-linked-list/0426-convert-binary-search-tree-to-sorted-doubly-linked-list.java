/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node head=null;
    Node prev=null;
    public void f(Node curr){
        if(curr==null){
            return;
        }
        f(curr.left);
        if(prev==null){
            head=curr;
            prev=curr;
        }
        else{
            curr.left=prev;
            prev.right=curr;
            prev=curr;
        }
        f(curr.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return root;
        }
        f(root);
        head.left=prev;
        prev.right=head;
        return head;
    }
}