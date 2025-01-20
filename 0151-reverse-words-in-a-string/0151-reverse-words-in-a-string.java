class Solution {
    public String reverseWords(String s) {
        s = s.trim(); // Remove leading and trailing spaces
        List<String> list = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
                continue; // Skip consecutive spaces
            }
            
            // Find the end of the current word
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            
            // Add the word to the list
            list.add(s.substring(i, j));
            i = j; // Move to the next character after the word
        }
        
        // Build the reversed result
        StringBuilder ans = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j--) {
            ans.append(list.get(j));
            if (j > 0) {
                ans.append(" "); // Add space between words
            }
        }
        
        return ans.toString();
    }
}
