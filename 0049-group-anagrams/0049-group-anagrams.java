class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        int freq[]=new int[26];
        for(String s:strs){
            Arrays.fill(freq,0);
            char ch[]=s.toCharArray();
            for(char c:ch){
                freq[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<26;i++){
               sb.append("#");
               sb.append(freq[i]);
            }
            String new_string=sb.toString();
            if(map.containsKey(new_string)==false){
                map.put(new_string,new ArrayList<>());
            }
            map.get(new_string).add(s);
        }
        return new ArrayList<>(map.values());
    }
}