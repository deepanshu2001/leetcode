class Solution {
    public int countKeyChanges(String s) {
        Map<Character,Integer> map=new HashMap<>();
        String p=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        return map.size()-1;
    }
}