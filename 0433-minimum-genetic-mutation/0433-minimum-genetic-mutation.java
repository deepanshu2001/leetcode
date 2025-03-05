class Solution {
    class Pair{
        int first;
        String second;
        Pair(int first,String second){
            this.first=first;
            this.second=second;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set=new HashSet<>();
        if(bank.length==0){
            return -1;
        }
        for(String s:bank){
            set.add(s);
        }
        if(set.contains(startGene)){
            set.remove(startGene);
        }
       
        Queue<Pair> q=new LinkedList<>();
        String words[]={"A","C","G","T"};
        q.add(new Pair(0, startGene));
        while(!q.isEmpty()){
            Pair p=q.remove();
            String s=p.second;
            int level=p.first;
            if(s.equals(endGene)){
                return level;
            }
            String new_word="";
            for(int i=0;i<s.length();i++){
                for(int j=0;j<4;j++){
                    new_word=s.substring(0,i)+words[j]+s.substring(i+1);
                    if(set.contains(new_word)){
                        q.add(new Pair(level+1,new_word));
                        set.remove(new_word);
                    }
                }
            }
        }
        return -1;

    }
}