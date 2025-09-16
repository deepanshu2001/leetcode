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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<TreeNode> st=new Stack<>();
        TreeNode node=root;
        while(!st.isEmpty() || node!=null){
            while(node!=null){
                st.push(node);
                node=node.left;
            }
            TreeNode temp=st.pop();
            ans.add(temp.val);
            node=temp.right;
        }
        return ans;

    }
}