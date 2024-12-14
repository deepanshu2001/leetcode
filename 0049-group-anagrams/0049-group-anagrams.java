class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            String new_str=new String(ch);
            if(map.containsKey(new_str)==false){
                map.put(new_str,new ArrayList<>());
            }
            map.get(new_str).add(s);
        }
        return new ArrayList(map.values());
    }
}