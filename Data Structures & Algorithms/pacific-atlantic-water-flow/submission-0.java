class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int rows = heights.length;
        int col = heights[0].length;

        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();

        for(int c = 0; c < col; c++) {
            dfs(0, c, heights, pac, heights[0][c]);
            dfs(rows-1, c, heights, atl, heights[rows-1][c]);
        }

        for(int r = 0; r < rows; r++) {
            dfs(r, 0, heights, pac, heights[r][0]);
            dfs(r, col-1, heights, atl, heights[r][col-1]);
        }

        if(pac.size() != atl.size()) {
            Set<List<Integer>> larger = pac.size() > atl.size() ? pac : atl;
            Set<List<Integer>> smaller = pac.size() < atl.size() ? pac : atl;
            larger.retainAll(smaller);
            return new ArrayList<>(larger);
        } else {
            pac.retainAll(atl);
            return new ArrayList<>(pac);
        }


    }
    public void dfs(int r, int c, int[][] heights, Set<List<Integer>> visited, int prevHeight) {
        if(r >= heights.length || r < 0 || c < 0 || c >= heights[0].length || visited.contains(List.of(r, c)) || prevHeight > heights[r][c]) {
            return;
        }
        visited.add(List.of(r,c));
        dfs(r + 1, c, heights, visited, heights[r][c]);
        dfs(r - 1, c, heights, visited, heights[r][c]);
        dfs(r, c + 1, heights, visited, heights[r][c]);
        dfs(r, c - 1, heights, visited, heights[r][c]);
    }
}
