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
    class Pair{
        TreeNode first;
        int second;
        Pair(TreeNode first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int maxDepth(TreeNode root) {
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(root,1));
        int ans=0;
        if(root==null){
            return 0;
        }
        while(!queue.isEmpty()){
            Pair pair=queue.remove();
            ans=Math.max(ans,pair.second);
            TreeNode node=pair.first;
            int level=pair.second;
            if(node.left!=null){
                queue.add(new Pair(node.left,level+1));
            }
            if(node.right!=null){
                queue.add(new Pair(node.right,level+1));
            }
        }
        return ans;
    }
}