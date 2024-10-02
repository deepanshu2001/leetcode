class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char ch[]=strs[i].toCharArray();
            Arrays.sort(ch);
            String temp=new String(ch);
            if(map.containsKey(temp)){
                map.get(temp).add(strs[i]);
            }
            else{
                ArrayList<String> ls=new ArrayList<>();
                ls.add(strs[i]);
                map.put(temp,ls);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> m:map.entrySet()){
            ans.add(m.getValue());
        }
        return ans;

    }
}