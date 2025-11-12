class Solution {
    public String processStr(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        boolean reversed = false;

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!dq.isEmpty()) {
                    if (!reversed) dq.removeLast();
                    else dq.removeFirst();
                }
            } 
            else if (ch == '%') {
                reversed = !reversed;
            } 
            else if (ch == '#') {
                // Lazy doubling using list snapshot
                int size = dq.size();
                List<Character> snapshot = new ArrayList<>(dq);
                if (reversed) Collections.reverse(snapshot);
                for (char c : snapshot) {
                    if (!reversed) dq.addLast(c);
                    else dq.addFirst(c);
                }
            } 
            else {
                if (!reversed) dq.addLast(ch);
                else dq.addFirst(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        if (!reversed) {
            for (char c : dq) ans.append(c);
        } else {
            while (!dq.isEmpty()) ans.append(dq.removeLast());
        }

        return ans.toString();
    }
}
