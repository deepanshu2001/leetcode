import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0, n = intervals.length;
        int s1 = newInterval[0], e1 = newInterval[1];

       
        while (i < n && intervals[i][1] < s1) {
            list.add(intervals[i]);
            i++;
        }

     
        while (i < n && intervals[i][0] <= e1) {
            s1 = Math.min(s1, intervals[i][0]);
            e1 = Math.max(e1, intervals[i][1]);
            i++;
        }
        list.add(new int[]{s1, e1});  

    
        while (i < n) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
