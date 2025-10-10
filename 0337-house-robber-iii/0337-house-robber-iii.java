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
    Map<TreeNode,Integer> map=new HashMap<>();
    public int f(TreeNode node){
        if(node==null){
            return 0;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        int nottake=f(node.left)+f(node.right);
        int take=node.val;
        int first=0;
        int second=0;
        int third=0;
        int fourth=0;
        if(node.left!=null){
            first=f(node.left.left);
            second=f(node.left.right);
        }
        if(node.right!=null){
            third=f(node.right.left);
            fourth=f(node.right.right);
        }
        take+=first+second+third+fourth;
        map.put(node,Math.max(take,nottake));
        return Math.max(take,nottake);
        
    
    }
    public int rob(TreeNode root) {
        return f(root);
    }
}