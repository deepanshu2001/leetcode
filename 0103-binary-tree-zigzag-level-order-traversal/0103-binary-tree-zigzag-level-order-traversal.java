

import static java.lang.Math.addExact;

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
    List<List<Integer>> ans=new ArrayList<>();
    public void dfs(TreeNode node,int level){
       if(level>=ans.size()){
         List<Integer> curr_level=new ArrayList<>();
         curr_level.add(node.val);
         ans.add(curr_level);
       }
       else{
        if(level%2==1){
            ans.get(level).add(0,node.val);
        }
        else{
            ans.get(level).add(node.val);
        }
       }
       if(node.left!=null){
        dfs(node.left,level+1);
       }
       if(node.right!=null){
        dfs(node.right, level+1);
       }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return ans;
        }
        dfs(root,0);
        return ans;
    }
}