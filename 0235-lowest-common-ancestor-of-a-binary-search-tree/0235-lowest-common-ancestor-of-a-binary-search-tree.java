/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans=null;
    public void f(TreeNode node,TreeNode p,TreeNode q){
        while(node!=null){
            if(node.val>p.val && node.val>q.val){
               node=node.left;
            }
            else if(node.val<p.val && node.val<q.val){
                node=node.right;
            }
            else{
                ans=node;
                break;
            }
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root==null){
        return null;
       }   
       f(root,p,q);
       return ans;
    }
}