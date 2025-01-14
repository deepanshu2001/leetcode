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
    public boolean f(TreeNode node,long min,long max){
        if(node==null){
            return true;
        }
        boolean flag=false;
        
        if(node.val>min && node.val<max){
            flag=true;
        }
        boolean left=f(node.left,min,node.val);
        boolean right=f(node.right,node.val,max);
        return flag&&(left&&right);
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null||root.left==null && root.right==null){
            return true;
        }
        return f(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}