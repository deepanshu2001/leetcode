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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        boolean Even=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                temp.add(node.val);
                if(Even){
                    if(node.val%2!=1){
                        return false;
                    }
                    if(temp.size()>1 && temp.get(temp.size()-1)<=temp.get(temp.size()-2)){
                        return false;
                    }
                }
                else{
                    if(node.val%2!=0){
                        return false;
                    }
                    if(temp.size()>1 &&(temp.get(temp.size()-1))>=temp.get(temp.size()-2)){
                        return false;
                    }
                }
            }
            Even=Even?false:true;
          
        }
        return true;
    }
}