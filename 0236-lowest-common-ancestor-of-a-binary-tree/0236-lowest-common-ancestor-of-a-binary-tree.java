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
    public TreeNode findLCA(TreeNode node,TreeNode p,TreeNode q){
        if(node==null){
            return null;
        }
        if(node.val==p.val||node.val==q.val){
            return node;
        }
        TreeNode left=findLCA(node.left,p,q);
        TreeNode right=findLCA(node.right,p,q);
        if(left!=null && right!=null){
            return node;
        }
        if(left==null && right==null){
            return null;
        }
        return left==null?right:left;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root.left==null && root.right==null){
            return root;
        }
        return findLCA(root,p,q);
    }
}