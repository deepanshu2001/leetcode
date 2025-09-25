class Node {
    boolean flag; // To mark the end of a word
    Node links[] = new Node[26]; // Array to store links for 26 letters

    Node() {
        // Constructor initializes flag as false by default
    }

    public boolean isEnd() {
        return flag;
    }

    public void setEnd() {
        flag = true;
    }

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

class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node(); // Initialize the root node
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd(); // Mark the end of the word
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int ind, Node node) {
        if (ind == word.length()) {
            return node.isEnd(); // Check if it's the end of a valid word
        }
        char ch = word.charAt(ind);
        if (ch == '.') {
            for (Node temp : node.links) {
                if (temp != null && searchInNode(word, ind + 1, temp)) {
                    return true;
                }
            }
            return false; // Only return false after checking all links
        } else {
            if (!node.containsKey(ch)) {
                return false;
            }
            return searchInNode(word, ind + 1, node.get(ch));
        }
    }
}

/**
 * Example usage:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord("word");
 * boolean param_2 = obj.search("w.rd");
 */
