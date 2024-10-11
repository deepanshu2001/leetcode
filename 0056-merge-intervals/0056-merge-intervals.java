class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        
        // Sort intervals by the starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < intervals.length; i++) {
            // If list is empty or current interval does not overlap
            if (list.isEmpty() || list.get(list.size() - 1).get(1) < intervals[i][0]) {
                // Create a new interval and add it to the list
                List<Integer> temp = new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
                list.add(temp);
            } else {
                // There is an overlap, so we merge the intervals by updating the end time
                list.get(list.size() - 1).set(1, Math.max(list.get(list.size() - 1).get(1), intervals[i][1]));
            }
        }
        
        // Convert list of lists to a 2D array
        int[][] ans = new int[list.size()][2];
        int index = 0;
        for (List<Integer> temp : list) {
            ans[index][0] = temp.get(0);
            ans[index][1] = temp.get(1);
            index++;
        }
        
        return ans;
    }
}
