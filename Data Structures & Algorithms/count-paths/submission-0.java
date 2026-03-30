class Solution {
    int count = 0;
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(grid[i], 0);
        }
        return countWays(grid, 0, 0, m, n);
    }
    public int countWays(int[][] grid, int r, int c, int m, int n) {
        if(r > m-1 || c > n-1) { return 0; }
        if(r == m-1 && c == n-1) {
            return 1 ;
        }
        if(grid[r][c] != 0) {
            return grid[r][c];
        }        
        return grid[r][c] = countWays(grid, r+1, c, m, n) + countWays(grid, r, c+1, m, n);
    }
}
