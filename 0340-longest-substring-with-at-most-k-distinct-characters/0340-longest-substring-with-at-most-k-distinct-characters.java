class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i=0;
        int ans=0;
        int j=0;
        Map<Character,Integer> map=new HashMap<>();
        while(j<s.length()){
           char ch=s.charAt(j);
           map.put(ch,map.getOrDefault(ch,0)+1);
           if(map.size()<=k){
            ans=Math.max(j-i+1,ans);
           }
           else{
            while(map.size()>k){
                char temp=s.charAt(i);
                map.put(temp,map.get(temp)-1);
                if(map.get(temp)==0){
                    map.remove(temp);
                }
                i++;
            }
           }
           j++;
        }
        return ans;
    }
}