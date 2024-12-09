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
    public TreeNode find(TreeNode node){
        while(node.right!=null){
            node=node.right;
        }
        return node;
    }
    public TreeNode helper(TreeNode node){
        if(node.left==null){
            return node.right;
        }
        else if(node.right==null){
            return node.left;
        }
        else{
            TreeNode leftChild=node.left;
            TreeNode rightChild=node.right;
            TreeNode rightMostChild=find(leftChild);
            rightMostChild.right=rightChild;
        }
        return node.left;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val==key){
            return helper(root);
        }
        TreeNode node=root;
        while(node!=null){
            if(node.val>key){
                if(node.left!=null && node.left.val==key){
                    node.left=helper(node.left);
                    break;
                }
                node=node.left;
            }
            else{
                if(node.right!=null && node.right.val==key){
                    node.right=helper(node.right);
                    break;
                }
                node=node.right;
            }
        }
        return root;
    }
}