class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int longestIncreasingPath(int[][] matrix) {
        int count = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                count = Math.max(count, lip(matrix, i, j, -1));
            }
        }
        return count;
    }
    public int lip(int[][] matrix, int r, int c, int prev) {
        if(r < 0 || r >= matrix.length) { return 0; }
        if(c < 0 || c >= matrix[0].length) { return 0; }
        if(matrix[r][c] <= prev) {
            return 0;
        }
        if(dp.containsKey(r+","+c)) {
            return dp.get(r+","+c);
        }
        int left = 1 + lip(matrix, r, c-1, matrix[r][c]);
        int right = 1 + lip(matrix, r, c+1, matrix[r][c]);
        int up = 1 + lip(matrix, r+1, c, matrix[r][c]) ;
        int down =  1 + lip(matrix, r-1, c, matrix[r][c]);
        int res = Math.max(Math.max(left, right), Math.max(up, down));
        dp.put(r+","+c, res);
        return res;
    }
}
