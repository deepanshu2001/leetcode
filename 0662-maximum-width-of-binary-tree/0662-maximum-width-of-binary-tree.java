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
        public Pair(TreeNode first,int second){
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
                Pair p=queue.remove();
                TreeNode node=p.first;
                int curr_id=p.second;
                if(i==0){
                   first=curr_id;
                }
                if(i==size-1){
                    last=curr_id;
                }
                if(node.left!=null){
                    queue.add(new Pair(node.left,2*curr_id+1));
                }
                if(node.right!=null){
                    queue.add(new Pair(node.right,2*curr_id+2));
                }
            }
            ans=Math.max(last-first+1,ans);
        }
        return ans;
    }
}