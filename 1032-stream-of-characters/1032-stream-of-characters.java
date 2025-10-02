class StreamChecker {
    class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }
        public Node get(char ch) {
            return links[ch - 'a'];
        }
        public void setEnd() {
            flag = true;
        }
        public boolean isEnd() {
            return flag;
        }
    }

    class Trie {
        Node root;
        Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            // Insert in reverse
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }
    }

    Trie trie;
    StringBuilder stream;
    int maxLen;

    public StreamChecker(String[] words) {
        trie = new Trie();
        maxLen = 0;
        for (String w : words) {
            trie.insert(w);
            maxLen = Math.max(maxLen, w.length());
        }
        stream = new StringBuilder();
    }

    public boolean query(char letter) {
        stream.append(letter);
        // Only need last maxLen characters
        if (stream.length() > maxLen) {
            stream.deleteCharAt(0);
        }

        Node node = trie.root;
        for (int i = stream.length() - 1; i >= 0; i--) {
            char ch = stream.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
            if (node.isEnd()) {
                return true;
            }
        }
        return false;
    }
}
