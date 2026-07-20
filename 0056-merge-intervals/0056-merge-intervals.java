import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        // Sort the intervals based on their starting values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> merged = new LinkedList<>();
        
        for (int[] interval : intervals) {
            // If the merged list is empty or the current interval does not overlap with the previous, add it
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Otherwise, there is an overlap, so merge the current interval with the previous one
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}