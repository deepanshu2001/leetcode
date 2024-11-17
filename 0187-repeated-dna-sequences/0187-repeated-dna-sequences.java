class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ans=new HashSet<>();
        if(s.length()<10){
            return new ArrayList<>();
        }
        Set<String> set=new HashSet<>();
        int i=0;
        while(i<=s.length()-10){
            String sub=s.substring(i,i+10);
            if(set.contains(sub)){
                ans.add(sub);
            }
            else{
                set.add(sub);
            }
            i++;
        }
        List<String> list=new ArrayList<>(ans);
        return list;
    }
}