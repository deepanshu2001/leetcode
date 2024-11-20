class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            
            int k = 0;
            while (k < Math.min(s1.length(), s2.length())) {
                char ch1 = s1.charAt(k);
                char ch2 = s2.charAt(k);
                if (ch1 != ch2) {
                    if (map.get(ch1) > map.get(ch2)) {
                        return false;
                    } else {
                        break;
                    }
                }
                k++;
            }
            // If one word is a prefix of another, the shorter word should come first
            if (k == s2.length() && s1.length() > s2.length()) {
                return false;
            }
        }
        return true;
    }
}
