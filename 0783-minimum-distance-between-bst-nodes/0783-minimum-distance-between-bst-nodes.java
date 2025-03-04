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
    TreeNode prev;
    int ans=Integer.MAX_VALUE;
    public void f(TreeNode node){
        if(node==null){
            return;
        }
        f(node.left);
        if(prev!=null){
            ans=Math.min(ans,Math.abs(node.val-prev.val));
        }
        prev=node;
        f(node.right);
    }
    public int minDiffInBST(TreeNode root) {
        f(root);
        return ans;
    }
}