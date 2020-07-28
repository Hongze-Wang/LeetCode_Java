// 200. Number of Islands

class Solution {
    int count;
    private boolean isSafe(char[][] grid, int i, int j) {
        return (i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == '1');
    }
    
    private void isLands(char[][] grid, int i, int j) {
        if(!isSafe(grid, i, j)) return;
        grid[i][j] = '2';
        isLands(grid, i, j+1);
        isLands(grid, i+1, j);
        isLands(grid, i-1, j);
        isLands(grid, i, j-1);
    }
    
    public int numIslands(char[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    isLands(grid, i, j);
                }
            }
        }
        return count;
    }
}
