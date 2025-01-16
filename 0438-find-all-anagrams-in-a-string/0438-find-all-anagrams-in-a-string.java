class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       List<Integer> ans=new ArrayList<>();
       if(s.length()<p.length()){
        return ans;
       }
       Map<Character,Integer> map1=new HashMap<>();
       for(int i=0;i<p.length();i++){
        char ch=s.charAt(i);
        map1.put(ch,map1.getOrDefault(ch,0)+1);
       }
       int i=0;
       int j=0;
       int k=p.length();
       Map<Character,Integer> map2=new HashMap<>();
       while(j<s.length()){
         char ch=s.charAt(j);
         map2.put(ch,map2.getOrDefault(ch,0)+1);
         if(j-i+1>k){
            char c=s.charAt(i);
            map2.put(c,map2.get(c)-1);
            if(map2.get(c)==0){
                map2.remove(c);
            }
            i++;
         }
         if(map1.equals(map2)){
            ans.add(i);
         }
         j++;
         }
         
       
       return ans;
    }
}