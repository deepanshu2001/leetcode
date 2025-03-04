class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) return ans;

        int wordLength = words[0].length();
        int numWords = words.length;
        int totalLength = wordLength * numWords;
        
        // Store the frequency of words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        
        // Sliding window approach using word-length offsets
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String sub = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordMap.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    count++;

                    // If we have more occurrences than needed, shrink the window
                    while (seen.get(sub) > wordMap.get(sub)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }

                    // If we have exactly all words, store the index
                    if (count == numWords) {
                        ans.add(left);
                    }
                } else {
                    // Reset everything if an invalid word is found
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return ans;
    }
}
