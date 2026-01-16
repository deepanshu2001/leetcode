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
    int ans=0;
    Set<TreeNode> set=new HashSet<>();
    public void dfs(TreeNode node,TreeNode par){
        if(node!=null){
            dfs(node.left,node);
            dfs(node.right,node);
            if(par==null && !set.contains(node) || !set.contains(node.left) || !set.contains(node.right)){
                ans++;
                set.add(node);
                set.add(par);
                set.add(node.left);
                set.add(node.right);
            }
            
        }
    }
    public int minCameraCover(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        set.add(null);
        dfs(root,null);
        return ans;
    }
}