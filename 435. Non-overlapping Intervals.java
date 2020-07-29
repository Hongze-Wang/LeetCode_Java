// 435. Non-overlapping Intervals

// sort by end is common choice
// greedy policy
// we delete the larger end end because it has the highest probablity to overlap with other

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int preEnd = intervals[0][1];
        int count = 0;
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= preEnd) { // Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
                preEnd = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
