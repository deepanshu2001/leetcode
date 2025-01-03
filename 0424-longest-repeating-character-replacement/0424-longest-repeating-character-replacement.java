class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int ans=0;
        int maxF=0;
        Map<Character,Integer> map=new HashMap<>();
        while(j<s.length()){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxF=Math.max(maxF,map.get(ch));
            while(j-i+1-maxF>k){
                char left=s.charAt(i);
                map.put(left,map.get(left)-1);
                i++;
            }
            ans=Math.max(j-i+1,ans);
            j++;
        }
        return ans;
    }
}