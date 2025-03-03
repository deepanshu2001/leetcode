class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map=new HashMap<>();
        String str[]=s.split(" ");
        if(str.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String k=str[i];
            if(!map.containsKey(ch)){
                map.put(ch,k);
            }
            else{
                if(map.get(ch).equals(k)==false){
                    return false;
                }
            }
        }
        Set<String> set=new HashSet<>();
        set.addAll(map.values());
        if(set.size()!=map.size()){
            return false;
        }
        return true;
    }
}