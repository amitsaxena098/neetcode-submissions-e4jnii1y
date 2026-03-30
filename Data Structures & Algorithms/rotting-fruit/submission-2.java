class Solution {
    public int orangesRotting(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<int[]> deq = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    deq.offerLast(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }
        int level = 0;
        while(!deq.isEmpty()) {
            int len = deq.size();
            for(int i = 0; i < len; i++) {
                int[] cords = deq.pollFirst();
                grid[cords[0]][cords[1]] = 2;
                addNeighbors(grid, visited, deq, cords[0]+1, cords[1]);
                addNeighbors(grid, visited, deq, cords[0]-1, cords[1]);
                addNeighbors(grid, visited, deq, cords[0], cords[1]+1);
                addNeighbors(grid, visited, deq, cords[0], cords[1]-1);
            }
            
            level += 1;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return level == 0 ? 0 : level-1;
    }
    public void addNeighbors(int[][] grid, boolean[][] visited, Deque<int[]> deq, int r, int c) {
        if(r > grid.length-1 || r < 0 || c > grid[0].length-1 || c < 0 || visited[r][c] || grid[r][c] == 0) {
            return;
        }
        deq.offerLast(new int[] {r, c});
        visited[r][c] = true;
    }
}
