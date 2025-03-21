class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        int ans=0;
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(j-i+1==k){
                if(map.size()==k){
                    ans++;
                }
            }
            if(j-i+1>k){
                char curr=s.charAt(i);
                map.put(curr,map.get(curr)-1);
                if(map.get(curr)==0){
                    map.remove(curr);
                }
                i++;
                if(map.size()==k){
                    ans++;
                }
            }
            j++;
        }
        return ans;
    }
}