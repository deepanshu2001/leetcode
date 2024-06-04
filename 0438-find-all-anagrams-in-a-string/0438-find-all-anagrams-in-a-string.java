import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map1 = new HashMap<>();
        
        // Initialize map1 with counts of characters in p
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        
        int k = p.length();
        Map<Character, Integer> map2 = new HashMap<>();
        int i = 0;
        int j = 0;
        
        while (j < s.length()) {
            char ch = s.charAt(j);
            
            // Increment the count for the current character in map2
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (map1.equals(map2)) {
                    ans.add(i);
                }
                
                // Remove or decrement the count of the character at index i in map2
                char c = s.charAt(i);
                if (map2.get(c) == 1) {
                    map2.remove(c);
                } else {
                    map2.put(c, map2.get(c) - 1);
                }
                
                i++;
                j++;
            }
        }
        
        return ans;
    }
}
