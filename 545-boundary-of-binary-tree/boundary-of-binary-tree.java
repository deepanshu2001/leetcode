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
    List<Integer> ans=new ArrayList<>();
    public void leftTraversal(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(node.left==null && node.right==null){
                break;
            }
            ans.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            else if(node.right!=null){
                queue.add(node.right);
            }
        }
    }
    public void leafTraversal(TreeNode root){
       if(root==null){
        return;
       }
       if(root.left==null && root.right==null){
        ans.add(root.val);
        return;
       }
       leafTraversal(root.left);
       leafTraversal(root.right);
    }
    public void rightTraversal(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> temp=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(node.left==null && node.right==null){
                break;
            }
            temp.add(node.val);
            if(node.right!=null){
                queue.add(node.right);
            }
            else if(node.left!=null){
                queue.add(node.left);
            }
        }
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
       
        if(root==null){
            return ans;
        }
        if(root.left==null && root.right==null){
            ans.add(root.val);
            return ans;
        }
        ans.add(root.val);
        leftTraversal(root.left);
        leafTraversal(root);
        rightTraversal(root.right);
        return ans;

    }
}