/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Node,Node> node_reference=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        node_reference.put(node,new Node(node.val));
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp=queue.remove();
            for(Node nei:temp.neighbors){
                if(!node_reference.containsKey(nei)){
                    node_reference.put(nei,new Node(nei.val));
                    queue.add(nei);
                }
                node_reference.get(temp).neighbors.add(node_reference.get(nei));
            }
        }
        return node_reference.get(node);
    }
}