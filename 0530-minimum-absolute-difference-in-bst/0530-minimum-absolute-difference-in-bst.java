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
    List<Integer> list=new ArrayList<>();
    public void f(TreeNode node){
        if(node==null){
            return;
        }
        f(node.left);
        list.add(node.val);
        f(node.right);
    }
    public int getMinimumDifference(TreeNode root) {
        f(root);
        return list.get(1)-list.get(0);
    }
}