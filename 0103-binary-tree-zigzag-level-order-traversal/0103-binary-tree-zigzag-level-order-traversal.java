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
    public void f(TreeNode node,int level,List<List<Integer>> ans){
        if(level>=ans.size()){
            List<Integer> temp=new ArrayList<>();
            temp.add(node.val);
            ans.add(new ArrayList<>(temp));
          
        }
        else{
            if(level%2==0){
                ans.get(level).add(node.val);
            }
            else{
                ans.get(level).add(0,node.val);
            }
        }
        if(node.left!=null){
            f(node.left,level+1,ans);
        }
        if(node.right!=null){
            f(node.right,level+1,ans);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        f(root,0,ans);
        return ans;
    }
}