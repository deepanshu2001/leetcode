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
        int third;
        public Pair(TreeNode first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       List<List<Integer>> ans=new ArrayList<>();
       if(root==null){
        return ans;
       }
       Queue<Pair> queue=new LinkedList<>();
       queue.add(new Pair(root,0,0));
       TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
       while(!queue.isEmpty()){
         Pair pair=queue.remove();
         TreeNode node=pair.first;
         int v=pair.second;
         int l=pair.third;
         if(!map.containsKey(v)){
            map.put(v,new TreeMap<>());
         }
         if(!map.get(v).containsKey(l)){
            map.get(v).put(l,new PriorityQueue<>());
         }
         map.get(v).get(l).add(node.val);
         if(node.left!=null){
            queue.add(new Pair(node.left,v-1,l+1));
         }
         if(node.right!=null){
            queue.add(new Pair(node.right,v+1,l+1));
         }
       }
       for(TreeMap<Integer,PriorityQueue<Integer>> mm:map.values()){
          ans.add(new ArrayList<>());
          for(PriorityQueue<Integer> pq:mm.values()){
            while(pq.size()!=0){
                ans.get(ans.size()-1).add(pq.remove());
            }
          }
       }
       return ans;
    }
}