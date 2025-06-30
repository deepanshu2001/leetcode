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
    public void f(TreeNode node,int target,List<Integer> temp){
        if(node.left==null && node.right==null && target==node.val){
            temp.add(node.val);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        if(node.left==null && node.right==null && target!=node.val){
            return;
        }
        temp.add(node.val);
        if(node.left!=null){
            f(node.left,target-node.val,temp);
        }
        if(node.right!=null){
            f(node.right,target-node.val,temp);
        }
        temp.remove(temp.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> temp=new ArrayList<>();
        if(root==null){
            return ans;
        }
        f(root,targetSum,temp);
        return ans;
    }
}