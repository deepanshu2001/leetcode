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
    public int findleftheight(TreeNode node){
        int cnt=0;
        while(node!=null){
            cnt++;
            node=node.left;
        }
        return cnt;
    }
    public int findrightheight(TreeNode node){
        int cnt=0;
        while(node!=null){
            cnt++;
            node=node.right;
        }
        return cnt;
    }
    public int f(TreeNode node){
        if(node==null){
            return 0;
        }
        int lh=findleftheight(node);
        int rh=findrightheight(node);
        if(lh==rh){
            return (int)Math.pow(2,lh)-1;
        }
        return 1+f(node.left)+f(node.right);
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return f(root);
    }
}