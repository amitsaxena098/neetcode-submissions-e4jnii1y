class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, area(grid, i, j));
                }
            }
        }
        return maxArea != Integer.MIN_VALUE ? maxArea : 0;
    }

    public int area(int[][] grid, int r, int c) {
        if(r > grid.length-1 || r < 0 ) { return 0; }
        if(c > grid[0].length-1 || c < 0 ) { return 0; }
        if(grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        return 1 + area(grid, r+1, c) + area(grid, r-1, c) + area(grid, r, c+1) + area(grid, r, c-1);
    }
}
