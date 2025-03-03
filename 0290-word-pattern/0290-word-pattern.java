class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap map=new HashMap();
        String str[]=s.split(" ");
        if(str.length!=pattern.length()){
            return false;
        }
        for(Integer  i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String k=str[i];
            if(!map.containsKey(ch)){
                map.put(ch,i);
            }
            if(!map.containsKey(k)){
                map.put(k,i);
            }
            if(map.get(ch)!=map.get(k)){
                return false;
            }
        }
        return true;
    }
}