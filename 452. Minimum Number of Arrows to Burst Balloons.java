// 452. Minimum Number of Arrows to Burst Balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));
        int res = 1;
        int preEnd = points[0][1];
        for(int i=1; i<points.length; i++) {
            if(points[i][0] > preEnd) { // A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend
                res++;
                preEnd = points[i][1];
            }
        }
        return res;
    }
}
