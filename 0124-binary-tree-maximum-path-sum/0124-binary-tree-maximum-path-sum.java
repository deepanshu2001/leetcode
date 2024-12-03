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
    int maxi=Integer.MIN_VALUE;
    public int f(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=Math.max(0,f(node.left));
        int right=Math.max(0,f(node.right));
        maxi=Math.max(maxi,node.val+left+right);
        return node.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        int h=f(root);
        return Math.max(maxi,h);
    }
}