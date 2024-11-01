class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int hash[] = new int[26];
            int maxF = 0; 
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                hash[ch - 'A']++;
                maxF = Math.max(maxF, hash[ch - 'A']);
                
                int changes = j - i + 1 - maxF;
                if (changes <= k) {
                    ans = Math.max(ans, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
