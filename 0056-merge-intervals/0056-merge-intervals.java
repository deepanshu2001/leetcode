class Solution {
    public int[][] merge(int[][] intervals) {

       Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 2: Use a List<int[]> to store the merged intervals
        List<int[]> list = new ArrayList<>();
        
        // Step 3: Traverse and merge intervals
        for (int i = 0; i < intervals.length; i++) {
            // If list is empty or there is no overlap, add the interval
            if (list.isEmpty() || intervals[i][0] > list.get(list.size() - 1)[1]) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                // Merge the current interval with the last interval in the list
                list.get(list.size() - 1)[1] = Math.max(intervals[i][1], list.get(list.size() - 1)[1]);
            }
        }
        
        // Step 4: Convert the list to a 2D array
        return list.toArray(new int[list.size()][]);
    }
}