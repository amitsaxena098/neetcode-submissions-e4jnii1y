class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count(grid, i, j);
                    total++;
                }
            }
        }
        return total;
    }
    public void count(char[][] grid, int r, int c) {
        if(r > grid.length-1 || r < 0) { return ;}
        if(c > grid[0].length-1 || c < 0) { return ; }
        if(grid[r][c] == '0') { return ;}
        grid[r][c] = '0';
        count(grid, r-1, c);
        count(grid, r+1, c);
        count(grid, r, c+1);
        count(grid, r, c-1);
    }
}
