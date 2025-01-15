class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String x = "";
        
        for (int i = 0; i < str2.length(); i++) {
            x += str2.charAt(i);
            StringBuilder sb = new StringBuilder(str1);
            
            // Remove all occurrences of x from sb
            while (sb.indexOf(x) == 0) { // Only remove if x is a prefix
                sb.delete(0, x.length());
            }
            
            // Check if sb is empty and if str2 can also be formed by x
            if (sb.length() == 0 && str2.replaceAll(x, "").isEmpty()) {
                return x;
            }
        }
        
        return "";
    }
}
