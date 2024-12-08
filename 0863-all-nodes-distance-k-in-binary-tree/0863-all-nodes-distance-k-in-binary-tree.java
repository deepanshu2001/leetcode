/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,TreeNode> parents=new HashMap<>();
    public void getHelp(TreeNode node){
        Queue<TreeNode> q=new LinkedList<>();
        parents.put(node,null);
        q.add(node);
        while(!q.isEmpty()){
            TreeNode temp=q.remove();
            if(temp.left!=null){
                q.add(temp.left);
                parents.put(temp.left,temp);
            }
            if(temp.right!=null){
                q.add(temp.right);
                parents.put(temp.right,temp);
            }
        }
        
    }
    class Pair{
        int first;
        TreeNode second;
        public Pair(int first,TreeNode second){
            this.first=first;
            this.second=second;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Map<TreeNode,Boolean> vis=new HashMap<>();
        getHelp(root);
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(0,target));
        vis.put(target,true);
        while(!queue.isEmpty()){
            Pair pair=queue.remove();
            int dis=pair.first;
            TreeNode node=pair.second;
            if(dis==k){
                ans.add(node.val);
                continue;
            }
            if(node.left!=null && vis.get(node.left)==null){
                queue.add(new Pair(dis+1,node.left));
                vis.put(node.left,true);
            }
            if(node.right!=null && vis.get(node.right)==null){
                queue.add(new Pair(dis+1,node.right));
                vis.put(node.right,true);
            }
            if(parents.get(node)!=null && vis.get(parents.get(node))==null){
                queue.add(new Pair(dis+1,parents.get(node)));
                vis.put(parents.get(node),true);
            }
        }
        return ans;
    }
}