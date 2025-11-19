class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int cnt[] = new int[26];
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                cnt[ch - 'a']++;
                int max_Freq = 0;
                int min_Freq = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        max_Freq = Math.max(max_Freq, cnt[k]);
                        min_Freq = Math.min(min_Freq, cnt[k]);
                    }
                }
                sum += max_Freq - min_Freq;
            }
        }
        return sum;
    }
}