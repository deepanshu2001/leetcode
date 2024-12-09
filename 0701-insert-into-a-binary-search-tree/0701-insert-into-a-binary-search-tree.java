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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode temp=new TreeNode(val);
            return temp;
        }
        TreeNode node=root;
        while(node!=null){
            if(node.right==null && node.left==null){
                if(node.val<val){
                    node.right=new TreeNode(val);
                }
                else{
                    node.left=new TreeNode(val);
                }
                break;
            }
            if(node.val<val){
                node=node.right;
            }
            else if(node.val>val){
                node=node.left;
            }
        }
        return root;
    }
}