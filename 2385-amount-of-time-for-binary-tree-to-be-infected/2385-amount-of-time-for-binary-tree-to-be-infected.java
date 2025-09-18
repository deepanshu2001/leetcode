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
    Map<TreeNode,TreeNode> parents=new HashMap<>();
    public TreeNode findNode(TreeNode root,int start){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode target=null;
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(node.val==start){
                target=node;
            }
            if(node.left!=null){
                parents.put(node.left,node);
                queue.add(node.left);
            }
            if(node.right!=null){
                parents.put(node.right,node);
                queue.add(node.right);
            }
        }
        return target;
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root==null){
            return 0;
        }
        TreeNode startNode=findNode(root,start);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        int ans=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(startNode);
        visited.put(startNode,true);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.remove();
                if(node.left!=null && visited.get(node.left)==null){
                    queue.add(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    queue.add(node.right);
                    visited.put(node.right,true);
                }
                if(parents.containsKey(node) && visited.get(parents.get(node))==null){
                    queue.add(parents.get(node));
                    visited.put(parents.get(node),true);
                }
            }
            ans++;
        }
        return ans-1;
    }
}