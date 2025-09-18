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
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root==null){
            return ans;
        }
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            int mmin=queue.peek().second;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                Pair pair=queue.remove();
                TreeNode node=pair.first;
                int id=pair.second-mmin;
                if(i==0){
                    first=id;
                }
                if(i==size-1){
                    last=id;
                }
                if(node.left!=null){
                    queue.add(new Pair(node.left,id*2+1));
                }
                if(node.right!=null){
                    queue.add(new Pair(node.right,id*2+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}