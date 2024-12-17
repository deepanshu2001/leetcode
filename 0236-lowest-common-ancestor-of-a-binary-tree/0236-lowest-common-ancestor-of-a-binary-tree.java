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
        if(node==null){
            return null;
        }
        if(node==p||node==q){
            return node;
        }
        TreeNode left=f(node.left,p,q);
        TreeNode right=f(node.right,p,q);
        if(left!=null && right!=null){
            return node;
        }
        if(left==null && right==null){
            return null;
        }
        return left==null?right:left;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return f(root,p,q);
    }
}