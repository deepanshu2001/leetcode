class MapSum {
    class Node {
        Node[] links = new Node[26];
        int score = 0;  // store cumulative score for prefix

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }
        public Node get(char ch) {
            return links[ch - 'a'];
        }
    }

    class Trie {
        Node root;
        Trie() {
            root = new Node();
        }

        public void insert(String word, int delta) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
                node.score += delta; // update prefix sums
            }
        }

        public int getSum(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (!node.containsKey(ch)) {
                    return 0;
                }
                node = node.get(ch);
            }
            return node.score;
        }
    }

    Map<String, Integer> map;
    Trie trie;

    public MapSum() {
        map = new HashMap<>();
        trie = new Trie();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0); // adjust if key already exists
        map.put(key, val);
        trie.insert(key, delta);
    }

    public int sum(String prefix) {
        return trie.getSum(prefix);
    }
}
