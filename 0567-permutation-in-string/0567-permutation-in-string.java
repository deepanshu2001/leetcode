class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int len=s1.length();
        for(int j=0;j<=s2.length()-len;j++){
            String s=s2.substring(j,j+len);
            Map<Character,Integer> new_map=new HashMap<>();
            for(int k=0;k<s.length();k++){
                char new_cha=s.charAt(k);
                new_map.put(new_cha,new_map.getOrDefault(new_cha,0)+1);

            }
            if(map.equals(new_map)){
                return true;
            }
            
        }
        return false;
    }
}