class Solution {
    public boolean check(String word,Set<String> set, Map<String,Boolean> map){
        if(map.get(word)!=null){
            return map.get(word);
        }
        for(int i=1;i<word.length();i++){
            String prefix=word.substring(0,i);
            String suffix=word.substring(i);
            if(set.contains(prefix) && (set.contains(suffix)||check(suffix,set,map))){
                map.put(word,true);
                return true;
            }
        }
        map.put(word,false);
        return false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans=new ArrayList<>();
        Map<String,Boolean> map=new HashMap<>();
        Set<String> set=new HashSet<>(Arrays.asList(words));
        for(String word:words){
            if(check(word,set,map)){
                ans.add(word);
            }
        }
        return ans;
    }
}