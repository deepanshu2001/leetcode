public class DisjointSet {
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int Upar=findUPar(parent.get(node));
        parent.set(node,Upar);
        return parent.get(node);

    }
    public void unionByRank(int u,int v){
        int up=findUPar(u);
        int vp=findUPar(v);
        if(up==vp){
            return;
        }
        if(rank.get(up)<rank.get(vp)){
            parent.set(up,vp);
        }
        else if(rank.get(vp)<rank.get(up)){
            parent.set(vp,up);
        }
        else{
            parent.set(vp,up);
            int rankU=rank.get(up);
            rank.set(up,rankU+1);
        }
    }
    public void unionBySize(int u,int v){
        int up=findUPar(u);
        int vp=findUPar(v);
        if(up==vp){
            return;
        }
        if(size.get(up)<size.get(vp)){
            parent.set(up,vp);
            size.set(vp,size.get(up)+size.get(vp));
        }
        else{
            parent.set(vp,up);
            size.set(up,size.get(up)+size.get(vp));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        Map<String,Integer> map=new HashMap<>();
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(map.containsKey(mail)==false){
                    map.put(mail,i);
                }else{
                    ds.unionBySize(i,map.get(mail));
                }
            }
        }
        ArrayList<String>[] mergeMail=new ArrayList[n];
        for(int i=0;i<n;i++){
            mergeMail[i]=new ArrayList<>();
        }
        for(Map.Entry<String,Integer> it:map.entrySet()){
            String mail=it.getKey();
            int node=ds.findUPar(it.getValue());
            mergeMail[node].add(mail);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergeMail[i].size()==0){
                continue;
            }
            Collections.sort(mergeMail[i]);
            ArrayList<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:mergeMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}