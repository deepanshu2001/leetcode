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
    public TreeNode buildTree(int inStart,int inEnd,int preStart,int preEnd,int []inorder,int []preorder,Map<Integer,Integer> inorderMap){
        if(inStart>inEnd||preStart>preEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int inRoot=inorderMap.get(root.val);
        int numsLeft=inRoot-inStart;
        root.left=buildTree(inStart,inRoot-1,preStart+1,preStart+numsLeft,inorder,preorder,inorderMap);
        root.right=buildTree(inRoot+1,inEnd,preStart+numsLeft+1,preEnd,inorder,preorder,inorderMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> InorderMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            InorderMap.put(inorder[i],i);
        }
        TreeNode root=buildTree(0,inorder.length-1,0,preorder.length-1,inorder,preorder,InorderMap);
        return root;
    }
}