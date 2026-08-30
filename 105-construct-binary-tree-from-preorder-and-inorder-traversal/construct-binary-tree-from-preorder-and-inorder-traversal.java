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
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode helper(int inStart,int inEnd,int preStart,int preEnd,int []inorder,int preorder[], Map<Integer,Integer> map){
        if(inStart>inEnd||preStart>preEnd){
            return null;
        }
       
        TreeNode node=new TreeNode(preorder[preStart]);
        int inorderRoot=map.get(node.val);
        int numsLeft=inorderRoot - inStart;
        node.left=helper(inStart,inorderRoot-1,preStart+1,preStart+numsLeft,inorder,preorder,map);
        node.right=helper(inorderRoot+1,inEnd,preStart+numsLeft+1,preEnd,inorder,preorder,map);
        return node;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(0,inorder.length-1,0,preorder.length-1,inorder,preorder,map);
    }

}