class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        Map<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        int k=s1.length();
        Map<Character,Integer> map2=new HashMap<>();
        int j=0;
        int i=0;
        while(j<s2.length()){
            char ch=s2.charAt(j);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if(j-i+1==k){
                if(map1.equals(map2)){
                    return true;
                }
            }
            if(j-i+1>k){
                while(j-i+1>k){
                    char new_char=s2.charAt(i);
                    map2.put(new_char,map2.getOrDefault(new_char,0)-1);
                    if(map2.get(new_char)==0){
                        map2.remove(new_char);
                    }
                    i++;
                }
                if(j-i+1==k){
                    if(map1.equals(map2)){
                        return true;
                    }
                }

            }
            j++;
        }
        return false;
    }
}