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
    public boolean f(TreeNode node,int target){
        if(node.left==null && node.right==null && target!=node.val){
            return false;
        }
        if(node.left==null && node.right==null && target==node.val){
            return true;
        }
        boolean left=false;
        if(node.left!=null){
            left=f(node.left,target-node.val);
        }
        boolean right=false;
        if(node.right!=null){
            right=f(node.right,target-node.val);
        }
        return left||right;
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return f(root,targetSum);
    }
}