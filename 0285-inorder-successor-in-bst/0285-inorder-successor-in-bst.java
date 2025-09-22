/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode succ=null;
    public void findSuccessor(TreeNode node,TreeNode p){
        if(node==null){
            return;
        }
        if(node.val<=p.val){
            findSuccessor(node.right,p);
        }
        if(node.val>p.val){
            succ=node;
            findSuccessor(node.left,p);
        }
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null){
            return null;
        }
        findSuccessor(root,p);
        return succ;
    }
}