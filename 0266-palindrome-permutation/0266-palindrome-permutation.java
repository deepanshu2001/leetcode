class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int cnt=1;
        if(map.size()==1){
            return true;
        }
        for(Map.Entry<Character,Integer> m:map.entrySet()){
            char ch=m.getKey();
            int val=m.getValue();
            if(val%2==1 && cnt!=1){
                return false;
            }
            else if(val%2==1){
                cnt--;
            }
        }
        return true;
    }
}