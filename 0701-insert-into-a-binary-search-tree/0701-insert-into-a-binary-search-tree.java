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
    public void f(TreeNode node,int val){
        if(node.val<val){
            if(node.right==null){
                node.right=new TreeNode(val);
                return;
            }
            f(node.right,val);
        }
        if(node.val>val){
            if(node.left==null){
                node.left=new TreeNode(val);
                return;
            }
            f(node.left,val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode temp=new TreeNode(val);
            return temp;
        }
        f(root,val);
        return root;
    }
}