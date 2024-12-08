/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean f(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null && q!=null || p!=null && q==null){
            return false;
        }
        return p.val==q.val && f(p.left,q.right) && f(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return f(root.left,root.right);
    }
}