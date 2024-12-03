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
    List<Integer> ans=new ArrayList<>();
    public boolean is_leaf(TreeNode node){
        if(node.left==null && node.right==null){
            return true;
        }
        return false;
    }
    public void LeftTraversal(TreeNode node){
        while(node.left!=null || node.right!=null){
            ans.add(node.val);
            if(node.left!=null){
                node=node.left;
            }
            else if(node.right!=null){
                node=node.right;
            }
        }
    }
    public void LeafTraversal(TreeNode node){
        if(node==null){
            return;
        }
        if(is_leaf(node)){
            ans.add(node.val);
        }
        LeafTraversal(node.left);
        LeafTraversal(node.right);
    }
    public void RightTraversal(TreeNode node,List<Integer> temp){
        while(node.left!=null || node.right!=null){
            temp.add(node.val);
            if(node.right!=null){
                node=node.right;
            }
            else{
                node=node.left;
            }
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root==null){
            return ans;
        }
        ans.add(root.val);
        if(is_leaf(root)){
            return ans;
        }
        if(root.left!=null){
            LeftTraversal(root.left);
        }
        LeafTraversal(root);
        List<Integer> temp=new ArrayList<>();
        if(root.right!=null){
            RightTraversal(root.right,temp);
        }
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
        return ans;
    }
}