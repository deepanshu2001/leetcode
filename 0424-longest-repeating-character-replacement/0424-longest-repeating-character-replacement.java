class Solution {
    public int characterReplacement(String s, int k) {
        int hash[]=new int[26];
        int i=0;
        int j=0;
        int maxFreq=Integer.MIN_VALUE;
        int ans=Integer.MIN_VALUE;
        while(j<s.length()){
            char ch=s.charAt(j);
            hash[ch-'A']++;
            maxFreq=Math.max(maxFreq,hash[ch-'A']);
            while(j-i+1-maxFreq>k){
                char c=s.charAt(i);
                hash[c-'A']--;
                i++;
            }
            ans=Math.max(j-i+1,ans);
            j++;
        }
        return ans;
    }
}