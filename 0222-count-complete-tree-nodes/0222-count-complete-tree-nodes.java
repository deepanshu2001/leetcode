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
    public int getLeftHeight(TreeNode node){
        int cnt=0;
        while(node.left!=null){
            cnt++;
            node=node.left;
        }
        return cnt;
    }
    public int getRightHeight(TreeNode node){
        int cnt=0;
        while(node.right!=null){
            cnt++;
            node=node.right;
        }
        return cnt;
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=getLeftHeight(root);
        int right=getRightHeight(root);
        if(left==right){
            return ((2<<(left))-1);
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}