class Solution {
    public int maximumLength(String s) {
        Map<Pair<Character,Integer>,Integer> map=new HashMap<>();
        for(int start=0;start<s.length();start++){
            char ch=s.charAt(start);
            int substring_length=0;
            for(int end=start;end<s.length();end++){
                if(ch==s.charAt(end)){
                    substring_length++;
                    Pair<Character,Integer> key=new Pair<>(ch,substring_length);
                    map.put(key,map.getOrDefault(key,0)+1);
                }
                else{
                    break;
                }
            }
        }
        int ans=-1;
        for(Map.Entry<Pair<Character,Integer>,Integer> entry:map.entrySet()){
            int len=entry.getKey().getValue();
            if(entry.getValue()>=3 && len>ans){
                ans=len;
            }
        }
        return ans;
    }
}