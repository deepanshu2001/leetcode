class FirstUnique {
    private Set<Integer> uniqueSet = new HashSet<>();
    private Set<Integer> duplicateSet = new HashSet<>();
    private ArrayDeque<Integer> queue = new ArrayDeque<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        // Clean the front of the queue if it contains duplicates
        while (!queue.isEmpty() && duplicateSet.contains(queue.peek())) {
            queue.poll();
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public void add(int value) {
        if (duplicateSet.contains(value)) {
            // Already marked as a duplicate, do nothing
            return;
        }

        if (uniqueSet.contains(value)) {
            // Value is no longer unique; move it to duplicateSet
            uniqueSet.remove(value);
            duplicateSet.add(value);
        } else {
            // New unique value
            uniqueSet.add(value);
            queue.add(value);
        }
    }
}
