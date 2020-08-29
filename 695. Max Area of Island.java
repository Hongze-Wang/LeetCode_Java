// 695. Max Area of Island

class Solution {
    
    private boolean isSafe(int[][] grid, int i, int j) {
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1);
    }
    
    private int areaOfIsland(int[][] grid, int i, int j) {
        if(!isSafe(grid, i, j)) return 0;
        grid[i][j] = 2;
        return areaOfIsland(grid, i+1, j) + areaOfIsland(grid, i, j+1) + areaOfIsland(grid, i-1, j) + areaOfIsland(grid, i, j-1) + 1;
        
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0, maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    area = areaOfIsland(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
