class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder s = new StringBuilder();
        s.append("1");
        
        for (int i = 2; i <= n; i++) {
            int k = 0;
            StringBuilder sb = new StringBuilder();
            
            while (k < s.length()) {
                int cnt = 1;
                int j = k + 1;
                while (j < s.length() && s.charAt(k) == s.charAt(j)) {
                    cnt++;
                    j++;
                }
                sb.append(cnt);
                sb.append(s.charAt(k));
                k = j; // Move to the next group
            }
            
            // Update `s` after processing the entire sequence
            s = sb;
        }
        
        return s.toString();
    }
}
