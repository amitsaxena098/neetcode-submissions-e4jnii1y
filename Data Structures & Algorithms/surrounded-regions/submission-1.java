class Solution {
    public void solve(char[][] board) {
     boolean[][] visited = new boolean[board.length][board[0].length];

     for(int i = 0; i < board[0].length; i++) {
        if(board[0][i] == 'O') {
            dfs(board, visited, 0, i);
        }
     }
     for(int i = 0; i < board[0].length; i++) {
        if(board[board.length-1][i] == 'O') {
            dfs(board, visited, board.length-1, i);
        }
     }
     for(int i = 0; i < board.length; i++) {
        if(board[i][0] == 'O') {
            dfs(board, visited, i, 0);
        }
     }
     for(int i = 0; i < board.length; i++) {
        if(board[i][board[0].length-1] == 'O') {
            dfs(board, visited, i, board[0].length-1);
        }
     }
     for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[0].length; j++) {
            if(board[i][j] == 'O') {
                board[i][j] = 'X';
            } else if(board[i][j] == '#') {
                board[i][j] = 'O';
            }
        }
     }

    }
    public void dfs(char[][] board, boolean[][] visited, int r, int c) {
        if(r > board.length-1 || r < 0 || c > board[0].length-1 || c < 0 || visited[r][c] ) {
            return;
        }
        if(board[r][c] == 'X') { return; }
        board[r][c] = '#';
        visited[r][c] = true;
        dfs(board, visited, r+1, c);
        dfs(board, visited, r-1, c);
        dfs(board, visited, r, c+1);
        dfs(board, visited, r, c-1);
    }
}
