// 120. Triangle
// DP
// min_triangle(i ,j) = min(triangle(i+1, j), triangle(i+1, j+1)) + triangle(i, j)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;

        int len = triangle.size();
        int[] memo = new int[len];
        List<Integer> lastRow = triangle.get(len-1), temp;
        for(int i=0; i<lastRow.size(); i++) {
            memo[i] = lastRow.get(i);
        }
        for(int i=len-2; i>=0; i--) {
            temp = triangle.get(i);
            for(int j=0; j<temp.size(); j++) {
                memo[j] = Math.min(memo[j], memo[j+1]) + temp.get(j);
            }
        }
        return memo[0];
    }
}
