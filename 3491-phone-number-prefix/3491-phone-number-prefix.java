class Solution {
    class Node {
        Node[] links = new Node[10];
        boolean flag = false;

        public boolean containsKey(char ch) {
            return links[ch - '0'] != null;
        }

        public Node get(char ch) {
            return links[ch - '0'];
        }

        public void put(char ch, Node node) {
            links[ch - '0'] = node;
        }

        public boolean isEnd() {
            return flag == true;
        }

        public void setEnd() {
            flag = true;
        }
    }

    public boolean phonePrefix(String[] numbers) {
        Node root = new Node();
        for (String word : numbers) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
                if (node.isEnd()) {
                    // smaller word is prefix of current word
                    return false;
                }
            }
            if (hasChildren(node)) {
                // current word is prefix of a longer word
                return false;
            }
            node.setEnd();
        }
        return true;
    }

    private boolean hasChildren(Node node) {
        for (Node child : node.links) {
            if (child != null) {
                return true;
            }
        }
        return false;
    }
}
