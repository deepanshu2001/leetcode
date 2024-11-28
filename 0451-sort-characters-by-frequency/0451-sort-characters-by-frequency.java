class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int maxF=Collections.max(map.values());
        List<List<Character>> buckets=new ArrayList<>();
        for(int i=0;i<=maxF;i++){
            buckets.add(new ArrayList<>());
        }
        for(Character key:map.keySet()){
            int freq=map.get(key);
            buckets.get(freq).add(key);
        }
        StringBuilder sb = new StringBuilder();
    for (int i = buckets.size() - 1; i >= 1; i--) {
        for (Character c : buckets.get(i)) {
            for (int j = 0; j < i; j++) {
                sb.append(c);
            }
        }
    }
    return sb.toString();

    }
}