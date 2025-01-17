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
    public TreeNode f(TreeNode node,TreeNode p,TreeNode q){
        if(node.val<p.val && node.val<q.val){
            return f(node.right,p,q);
        }
        else if(node.val>p.val && node.val>q.val){
            return f(node.left,p,q);
        }
        else if(node.val>=p.val && node.val<=q.val){
            return node;
        }
        return node;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        return f(root,p,q);
    }
}