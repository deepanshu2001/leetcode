import java.util.*;

class Solution {
    class Pair {
        int freq;
        char ch;
        Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : map.values()) {
            pq.add(freq);
        }

        int deletions = 0;

        while (pq.size() > 1) {
            int top = pq.poll();
            if (top == pq.peek()) { // duplicate frequency
                if (top - 1 > 0) pq.add(top - 1);
                deletions++;
            }
        }

        return deletions;
    }
}
