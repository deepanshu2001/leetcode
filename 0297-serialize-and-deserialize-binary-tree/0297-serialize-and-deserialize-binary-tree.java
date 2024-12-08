/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.remove();
                if(node==null){
                    sb.append("# ");
                    continue;
                }
                sb.append(node.val+" ");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==""){
            return null;
        }
        String values[]=data.split(" ");
       
        int j=1;
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.remove();
            if(!values[j].equals("#")){
                node.left=new TreeNode(Integer.parseInt(values[j]));
                q.add(node.left);
            }
            j++;
            if(!values[j].equals("#")){
                node.right=new TreeNode(Integer.parseInt(values[j]));
                q.add(node.right);
            }
            j++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));