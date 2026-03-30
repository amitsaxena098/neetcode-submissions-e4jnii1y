class Solution {
    public void islandsAndTreasure(int[][] grid) {
        getTreasure(grid);
    }
    public void getTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<int[]> deq = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    deq.offerLast(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        int dist = 0;
        while(!deq.isEmpty()) {
            int len = deq.size();
            for(int i = 0; i < len; i++) {
                int[] cords = deq.pollFirst();
                grid[cords[0]][cords[1]] = dist;
                addNeighbors(grid, visited, cords[0]+1, cords[1], deq);
                addNeighbors(grid, visited, cords[0]-1, cords[1], deq);
                addNeighbors(grid, visited, cords[0], cords[1]+1, deq);
                addNeighbors(grid, visited, cords[0], cords[1]-1, deq);
            }
            dist += 1;
        }

    }
    public void addNeighbors(int[][] grid, boolean[][] visited, int r, int c, Deque<int[]> deq) {
        if(r > grid.length-1 || r < 0 || c > grid[0].length-1 || c < 0 || visited[r][c] || grid[r][c] == -1) {
            return;
        }
        deq.offerLast(new int[] {r, c});
        visited[r][c] = true;

    }
}
