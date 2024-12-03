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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Boolean flag=true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
               TreeNode node=q.remove();
               if(node.left!=null){
                  q.add(node.left);
               }
               if(node.right!=null){
                  q.add(node.right);
               }
               if(flag==true){
                temp.add(node.val);
               }
               else if(flag==false){
                   temp.add(0,node.val);
               }
            }
            if(flag==true){
                flag=false;
            }
            else if(flag==false){
                flag=true;
            }
            ans.add(temp);
        }
        return ans;
    }
}