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
    int moves=0;
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftsub=dfs(node.left);
        int rightsub=dfs(node.right);
        moves+=Math.abs(leftsub)+Math.abs(rightsub);
        return node.val+leftsub+rightsub-1;
    }
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
}