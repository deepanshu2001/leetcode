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
    List<List<Integer>> list=new ArrayList<>();
    public void dfs(TreeNode node,int level){
       if(list.size()==level){
        list.add(new ArrayList<>());
       }
       list.get(level).add(node.val);
       if(node.left!=null){
        dfs(node.left,level+1);
       }
       if(node.right!=null){
        dfs(node.right,level+1);
       }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        List<Integer> temp=new ArrayList<>();
        dfs(root,0);
        for(List<Integer> l:list){
            int size=l.size();
            long sum=0;
            for(int num:l){
              sum+=num;
            }
            ans.add(sum*1.0/size);
        }
        return ans;
    }
}