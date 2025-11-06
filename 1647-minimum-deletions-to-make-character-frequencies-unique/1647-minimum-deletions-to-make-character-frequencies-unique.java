class Solution {
    public int minDeletions(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        Set<Integer> set=new HashSet<>();
        int cnt=0;
        for(int i=0;i<26;i++){
            while(freq[i]>0 && set.contains(freq[i])){
                freq[i]--;
                cnt++;
            }
            set.add(freq[i]);
        }
        return cnt;
    }
}