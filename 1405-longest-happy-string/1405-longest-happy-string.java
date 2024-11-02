class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        
        // Array to hold counts and corresponding characters
        int[][] counts = {{a, 'a'}, {b, 'b'}, {c, 'c'}};
        
        while (true) {
            // Sort counts to make the character with the highest count first
            Arrays.sort(counts, (x, y) -> y[0] - x[0]);
            
            boolean added = false;
            
            for (int i = 0; i < 3; i++) {
                int count = counts[i][0];
                char ch = (char) counts[i][1];
                
                // Check if this character can be added without causing three in a row
                int len = result.length();
                if (count > 0 && !(len >= 2 && result.charAt(len - 1) == ch && result.charAt(len - 2) == ch)) {
                    // Add the character
                    result.append(ch);
                    counts[i][0]--;  // Decrease the count for this character
                    added = true;
                    break;
                }
            }
            
            // If no character was added in this iteration, break the loop
            if (!added) break;
        }
        
        return result.toString();
    }
}
