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
    public TreeNode RecursiveTraversal(int []preorder,int preStart,int preEnd,int inorder[],int inStart,int inEnd,Map<Integer,Integer> inorderIndexMap){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int inRoot=inorderIndexMap.get(root.val);
        int numsleft=inRoot-inStart;
        root.left=RecursiveTraversal(preorder,preStart+1,preStart+numsleft,inorder,inStart,inRoot-1,inorderIndexMap);
        root.right=RecursiveTraversal(preorder,preStart+numsleft+1,preEnd,inorder,inRoot+1,inEnd,inorderIndexMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderIndexMap=new HashMap<>();
        for(int iter=0;iter<inorder.length;iter++){
            inorderIndexMap.put(inorder[iter],iter);
        }
        TreeNode root=RecursiveTraversal(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inorderIndexMap);
        return root;
    }
}