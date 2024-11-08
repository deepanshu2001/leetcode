class Node{
    Node links[]=new Node[2];
    public boolean containsKey(int ind){
        return (links[ind]!=null);
    }
    Node get(int ind){
        return links[ind];
    }
    public void put(int ind,Node node){
        links[ind]=node;
    }
}
class Trie{
    private Node root;
    Trie(){
        root=new Node();
    }
    public void insert(int num){
       Node node=root;
       for(int i=31;i>=0;i--){
           int bit=(num>>i)&1;
           if(!node.containsKey(bit)){
               node.put(bit,new Node());
           }
           node=node.get(bit);
       }
    }
    public int getMax(int num){
        Node node=root;
        int max_num=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.containsKey(1-bit)){
               max_num=max_num | (1<<i);
               node=node.get(1-bit);
            }
            else{
                node=node.get(bit);
            }
        }
        return max_num;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie obj=new Trie();
        for(int i=0;i<nums.length;i++){
            obj.insert(nums[i]);
        }
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,obj.getMax(nums[i]));
        }
        return maxi;
    }
}