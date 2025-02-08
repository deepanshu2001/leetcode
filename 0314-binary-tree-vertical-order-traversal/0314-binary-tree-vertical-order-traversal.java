class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.offer(new Pair<>(root, 0));
        map.put(0, new ArrayList<>(Arrays.asList(root.val)));
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int col = pair.getValue();
            
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, col - 1));
                map.computeIfAbsent(col - 1, k -> new ArrayList<>()).add(node.left.val);
            }
            
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, col + 1));
                map.computeIfAbsent(col + 1, k -> new ArrayList<>()).add(node.right.val);
            }
        }
        
        return new ArrayList<>(map.values());
    }
}