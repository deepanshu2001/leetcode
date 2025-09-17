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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(root,0));
        TreeMap<Integer,Integer> map=new TreeMap<>();
        while(!queue.isEmpty()){
            Pair pair=queue.remove();
            TreeNode node=pair.first;
            int level=pair.second;
            if(!map.containsKey(level)){
                map.put(level,node.val);
            }
            if(node.right!=null){
                queue.add(new Pair(node.right,level+1));
            }
            if(node.left!=null){
                queue.add(new Pair(node.left,level+1));
            }
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
}