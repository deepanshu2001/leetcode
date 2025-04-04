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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return f(root).getKey();
    }
    public Pair<TreeNode,Integer> f(TreeNode node){
        if(node==null){
            return new Pair<>(null,0);
        }
        Pair<TreeNode,Integer> left=f(node.left);
        Pair<TreeNode,Integer> right=f(node.right);
        if(left.getValue()<right.getValue()){
            return new Pair<>(right.getKey(),right.getValue()+1);
        }
        if(left.getValue()>right.getValue()){
            return new Pair<>(left.getKey(),left.getValue()+1);
        }
        return new Pair<>(node,left.getValue()+1);
    }
   
}