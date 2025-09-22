/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        // code here
        int ciel=-1;
        while(root!=null){
            if(root.data<x){
                root=root.right;
            }
            else if(root.data>=x){
                ciel=root.data;
                root=root.left;
            }
        }
        return ciel;
    }
}