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
        Map<Node,Node> map=new HashMap<>();
        return F(node,map);
    }
    public Node F(Node node,Map<Node,Node> map){
        Node copy=new Node(node.val);
        map.put(node,copy);
        for(Node nei:node.neighbors){
            if(map.containsKey(nei)){
               copy.neighbors.add(map.get(nei));
            }
            else{
                Node cloned=F(nei,map);
                copy.neighbors.add(cloned);
            }
        }
        return copy;
    }
}