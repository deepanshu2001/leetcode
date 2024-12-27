class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<>();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(map.containsKey(ch1) && map.get(ch1)!=ch2){
                return false;
            }
            if(!map.containsKey(ch1) && set.contains(ch2)){
                return false;
            }
            set.add(ch2);
            map.put(ch1,ch2);
        }
        return true;
    }
}