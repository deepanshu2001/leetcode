

import static java.lang.Math.log;

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
    public List<Double> averageOfLevels(TreeNode root) {
       List<Double> ans=new ArrayList<>();
       if(root==null){
          return ans; 
       }
       List<List<Integer>> list=new ArrayList<>();
       Queue<TreeNode> q=new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
         int size=q.size();
         List<Integer> temp=new ArrayList<>();
         for(int i=0;i<size;i++){
            TreeNode node=q.remove();
            temp.add(node.val);
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
         }
         list.add(new ArrayList<>(temp));
       }
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