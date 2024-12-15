class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int ans=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()==j-i+1){
                ans=Math.max(ans,j-i+1);
            }
            while(j-i+1>map.size()){
                char c=s.charAt(i);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    map.remove(c);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}