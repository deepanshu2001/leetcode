class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
           char ch=magazine.charAt(i);
           m.put(ch,m.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char ch1=ransomNote.charAt(i);
            if(m.containsKey(ch1)==false || m.get(ch1)==0){
                return false;
            }
            for(int j=0;j<magazine.length();j++){
                char ch2=magazine.charAt(j);
                if(ch1==ch2){
                    m.put(ch1,m.get(ch1)-1);
                    break;
                }
            }
        }
        return true;
    }
}