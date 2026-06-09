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
    Map<Integer,int []> map;
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,int []> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int description[]:descriptions){
            int parent=description[0];
            int child=description[1];
            int isleft=description[2];
            if(!map.containsKey(parent)){
                map.put(parent,new int[2]);
            }
            if(isleft==1){
                map.get(parent)[0]=child;
            }
            else{
                map.get(parent)[1]=child;
            }
            set.add(child);
        }
        TreeNode root=null;
        for(Map.Entry<Integer,int []> m:map.entrySet()){
            if(!set.contains(m.getKey())){
                root=new TreeNode(m.getKey());
                break;
            }
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(map.containsKey(node.val)){
                int arr[]=map.get(node.val);
                if(arr[0]!=0){
                    node.left=new TreeNode(arr[0]);
                    queue.add(node.left);
                }
                if(arr[1]!=0){
                    node.right=new TreeNode(arr[1]);
                    queue.add(node.right);
                }
            }
        }
        return root;

        
    }
}